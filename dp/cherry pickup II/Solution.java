class Solution {
    public int cherryPickup(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;
        
        int n = grid.length;
        int[][][] help = new int[n][n][n];
        
        help[0][0][0] = grid[0][0];
        
        for(int i = 0; i < n; ++i)
        {
            for(int j = 0; j < n; ++j)
            {
                for(int k = 0; k < n; ++k)
                {
                    if(i == 0 && j == 0) continue;
                    int t = i+j-k;
                    if(t < 0 || t >= n)
                    {
                        help[i][j][k] = -1;
                        continue;
                    }
                    if(grid[i][j] == -1 || grid[k][t] == -1)
                    {
                        help[i][j][k] = -1;
                        continue;
                    }
                    help[i][j][k] = Math.max(((i > 0 && k >0)?help[i-1][j][k-1]:-1),((j > 0 && t >0)?help[i][j-1][k]:-1));
                    help[i][j][k] = Math.max(help[i][j][k],Math.max(((i > 0 && t >0)?help[i-1][j][k]:-1),((j > 0 && k >0)?help[i][j-1][k-1]:-1)));
                    if(help[i][j][k] < 0) 
                    {
                        help[i][j][k] = -1;
                        continue;
                    }
                    
                    help[i][j][k] += grid[i][j] + ((i == k)? 0 : grid[k][t]); 
                 }
            }
        }
        return Math.max(0,help[n-1][n-1][n-1]);
        
    }
}