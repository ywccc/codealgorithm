class Solution {
    public int minSteps(int n) {
        if(n == 0) return 0;
        if(n == 1) return 0;
        if(n <= 3) return n;
        int[] help = new int[n+1];
        help[1] = 0;
        help[2] = 2;
        help[3] = 3;
        for(int i = 4; i <= n; ++i)
        {
            help[i] = i;
            for(int j = 2; j <= i/2; ++j)
            {
                if(i % j == 0)
                {
                    help[i] = Math.min(help[i], help[j] + i/j);
                }
            }
        }
        return help[n];
        
    }
}
