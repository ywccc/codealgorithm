class Solution {
    public int numTrees(int n) {
        if(n <= 1) return 1;
        int[] help = new int[n+1];
        help[0] = 1;
        help[1] = 1;
        help[2] = 2;
        for(int i = 3; i <= n; ++i)
        {
            for(int j = 0; j <= i-1; ++j)
            {
                help[i] += help[j]*help[i-1-j];
            }
        }
        
        return help[n];
    }
}