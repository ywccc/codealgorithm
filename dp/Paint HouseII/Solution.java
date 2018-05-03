class Solution {
    public int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0 || costs[0] == null || costs[0].length == 0) return 0;
        
        int n = costs.length;
        int k = costs[0].length;
        
        int[][] help = new int[n][k];
        int min1 = -1;
        int min2 = -1;
        
        for(int i = 0; i < k; ++i)
        {
            help[0][i]= costs[0][i];
            if(min1 < 0 || help[0][min1] > costs[0][i])
            {
                min2 = min1;
                min1 = i;
            }
            else if(min2 < 0 || help[0][min2] > costs[0][i])
            {
                min2 = i;
            }
        }
        
        
        for(int i = 1; i < n; ++i)
        {
    
            int mm1 = -1;
            int mm2 = -1;
            for(int j = 0; j < k; ++j)
            {
                if(j == min1)
                {
                    help[i][j] = costs[i][j] + help[i-1][min2];
                }
                else
                {
                    help[i][j] = costs[i][j] + help[i-1][min1];
                }
                
                if(mm1 < 0 || help[i][mm1] > help[i][j])
                {
                    mm2 = mm1;
                    mm1 = j;
                }
                else if(mm2 < 0 || help[i][mm2] > help[i][j])
                {
                    mm2 = j;
                }
            }
            min1 = mm1;
            min2 = mm2;
        }
        return help[n-1][min1];
    }
}
