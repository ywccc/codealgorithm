class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return 0;
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[] help = new int[n];
        
        int res = 0;
        for(int i = 0; i < m; ++i)
        {
            for(int j = 0; j < n; ++j)
            {
                if(i == 0) 
                {
                    help[j] = (matrix[i][j] == '1')?1:0;
                }
                else 
                {
                    help[j] = (matrix[i][j] == '1')?help[j]+1:0;
                }
            }
            res = Math.max(res,search(help,n));
        }
        return res;
    }
    
    public int search(int[] help,int n)
    {
        int[] left = new int[n];
        int[] right = new int[n];
        int res = 0;
        left[0] = -1;
        right[n-1] = n;
        for(int i = 1; i < n; ++i)
        {
            int j = i - 1;
            while(j >=0 && help[j] >= help[i])
            {
                j = left[j];
            }
            left[i] = j;
        }
        for(int i = n-2; i >=0; --i)
        {
            int j = i + 1;
            while(j < n && help[j] >= help[i])
            {
                j = right[j];
            }
            right[i] = j;
        }
        
        for(int i = 0; i < n; ++ i)
        {
            res = Math.max(res,help[i]*(right[i] - left[i] - 1));
        }
        return res;
    }
}