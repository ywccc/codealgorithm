class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A == null || A.length < 3) return 0;
        
        int len = A.length;
        boolean[][] help = new boolean[len][len];
        int res = 0;
        for(int i = 0; i < len-2; ++i)
        {
            if(A[i+2] + A[i] == 2*A[i+1])
            {
                help[i][i+2] = true;
                ++res;
            }
        }
        
        for(int i = 4; i <= len; ++i)
        {
            for(int j = 0; j <= len-i; ++j)
            {
                if(help[j][j+i-2] && (A[j+i-1] - A[j+i-2] == A[j+i-2] - A[j+i-3]))
                {
                    help[j][j+i-1] = true;
                    ++res;
                }
            }
        }
        return res;
    }
}