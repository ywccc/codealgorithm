class Solution {
    public int maxVacationDays(int[][] flights, int[][] days) {
        if(flights == null || days == null) return 0;
        
        int N = days.length;
        int K = days[0].length;
        int[][] help = new int[N][K];
        boolean[][] get = new boolean[N][K];
        help[0][0] = days[0][0];
        get[0][0] = true;
        for(int i = 1; i < N; ++i)
        {
            help[i][0] = (flights[0][i] == 1)? days[i][0]:0;
            get[i][0] = (flights[0][i] == 1)?true:false;
        }
        
        for(int j = 1; j < K; ++j)
        {
            for(int i = 0; i < N; ++i)
            {
                help[i][j] = Integer.MIN_VALUE;
                for(int k = 0; k < N; ++k)
                {
                    if((flights[k][i] == 1 && get[k][j-1]) || (k == i && get[i][j-1]))
                    {
                        help[i][j] = Math.max(help[i][j],help[k][j-1]+days[i][j]);
                        get[i][j] = true;
                    }
                }
            }
        }
        int res = 0;
        for(int i = 0; i < N; ++i)
        {
            if(get[i][K-1])
            {
                res = Math.max(res,help[i][K-1]);
            }
        }
        return res;
        
    }
}
