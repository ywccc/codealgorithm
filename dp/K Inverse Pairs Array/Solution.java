class Solution {
    public int kInversePairs(int n, int k) {
        int mod = 1000000007;
        if(k < 0 || k > (n-1)*n/2) return 0;
        if(k == 0 || k == (n-1)*n/2) return 1;
        long[][] help = new long[n+1][k+1];
        
        help[2][0] = 1;
        help[2][1] = 1;
        for(int i = 3; i <= n; ++i)
        {
            help[i][0] = 1;
            for(int j = 1; j <= Math.min(k,(i-1)*i/2); ++j)
            {
                help[i][j] = help[i][j-1] + help[i-1][j];
                if(j >= i) help[i][j] -= help[i-1][j-i];
                help[i][j] = (help[i][j] + mod) % mod;
            }
        }
        return (int)help[n][k];
    }
}
