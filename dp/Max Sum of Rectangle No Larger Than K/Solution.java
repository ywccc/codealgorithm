class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return 0;
        
        int m = matrix.length;
        int n = matrix[0].length;
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < n; ++i)
        {
            int[] help = new int[m];
            for(int j = i; j < n; ++j)
            {
                for(int p = 0; p < m; ++p)
                {
                    help[p] += matrix[p][j];
                }
                int ans = find(help,k);
                //System.out.println(ans);
                if(ans <= k && ans > res) res = ans;
            }
        }
        return res;
    }
    
    
    public int find(int[] help, int k)
    {
        int[] sum = new int[help.length];
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < help.length; ++i)
        {
            if(i == 0) sum[i] = help[0];
            else sum[i] = help[i] + sum[i-1];
            if(sum[i] <= k && res < sum[i])
            {
                res = sum[i];
            }
        }
        
        for(int i = 1; i < help.length; ++i)
        {
            for(int j = 0; j < i; ++j)
            {
                if(sum[i] - sum[j] <= k && res < sum[i] - sum[j])
                {
                    res = sum[i] - sum[j];
                }
            }
        }
        return res;
    }
}