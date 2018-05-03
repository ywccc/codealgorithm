class Solution {
    public int integerBreak(int n) {
        if(n <= 1) return 0;
        int[] help = new int[n+1];
        help[0] = 0;
        help[1] = 1;
        
        for(int i = 2; i <= n; ++i)
        {
            help[i] = 0;
            for(int j = 1; j < i; ++j)
            {
                help[i] = Math.max(Math.max(j*(i-j),help[i-j]*j),help[i]);
            }
        }
        return help[n];
    }
}
