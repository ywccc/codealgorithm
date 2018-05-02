class Solution {
    public double largestSumOfAverages(int[] A, int K) {
        if(A == null || A.length == 0) return 0;
        int[] sum = new int[A.length];
        for(int i = 0; i < A.length; ++i)
        {
            sum[i] = (i==0)?A[0]:A[i]+sum[i-1];
        }
        
        double[][] help = new double[K+1][A.length];
        for(int i = 1; i <= K; ++i)
        {
            for(int j = 0; j < A.length; ++j)
            {
                if(i == 1) 
                {
                    help[i][j] = (double)sum[j]/(j+1);
                    continue;
                }
                if(i > j+1) continue;
                help[i][j] = Integer.MIN_VALUE;
                for(int k = 0; k < j; ++k)
                {
                    if(i-1 > k+1) continue;
                    help[i][j] = Math.max(help[i][j],help[i-1][k]+(double)(sum[j]-sum[k])/(j-k));
                }
            }
        }
        double res = Integer.MIN_VALUE;
        for(int i = 1; i <= K; ++i)
        {
            res = Math.max(res,help[i][A.length-1]);
        }
        return res;
    }
}