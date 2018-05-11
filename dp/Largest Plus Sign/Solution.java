class Solution {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        if(N <= 0) return 0;
        int[][][] help = new int[N][N][5]; // 0 : min ; 1:left; 2: top; 3: right; 4:down
        int[][] nums = new int[N][N];
        for(int i = 0; i < mines.length; ++i)
        {
            nums[mines[i][0]][mines[i][1]] = 1;
        }
        for(int i = 0; i < N; ++i)
        {
            for(int j = 0; j < N; ++j)
            {
                if(nums[i][j] == 1)
                {
                    continue;
                }
                else
                {
                    help[i][j][1] = ((i == 0) ? 0 : help[i-1][j][1]) + 1;
                    help[i][j][2] = ((j == 0) ? 0 : help[i][j-1][2]) + 1;
                    help[i][j][0] = Math.min(help[i][j][1],help[i][j][2]);
                }
            }
        }
        
        for(int i = N-1; i >= 0; --i)
        {
            for(int j = N-1; j >= 0; --j)
            {
                if(nums[i][j] == 1) 
                {
                    continue;
                }
                else
                {
                    help[i][j][3] = ((i == N-1) ? 0 : help[i+1][j][3]) + 1;
                    help[i][j][4] = ((j == N-1) ? 0 : help[i][j+1][4]) + 1;
                    help[i][j][0] = Math.min(help[i][j][3],Math.min(help[i][j][4],help[i][j][0]));
                }
            }
        }
        int res = 0;
        for(int i = 0; i < N; ++i)
        {
            for(int j = 0; j < N; ++j)
            {
                res = Math.max(res,help[i][j][0]);
            }
        }
        return res;
    }
}
