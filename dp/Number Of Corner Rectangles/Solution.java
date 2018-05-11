class Solution {
    public int countCornerRectangles(int[][] grid) {
        if(grid == null || grid.length <= 1 || grid[0] == null || grid[0].length <= 1) return 0;
        int n = grid[0].length;
        int[][] help = new int[n][n];
        
        int res = 0;
        for(int i = 0; i < grid.length; ++i)
        {
            for(int j = 0; j < n; ++j)
            {
                if(grid[i][j] == 0) continue;
                for(int k = j+1; k < n; ++k)
                {
                    if(grid[i][k] == 0) continue;
                    res += help[j][k];
                    ++help[j][k];
                }
            }
        }
        return res;
    }
}
