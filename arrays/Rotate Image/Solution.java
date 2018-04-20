class Solution {
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return;
        for(int i = 0; i < matrix.length; ++i)
        {
            for(int  j = i+1; j < matrix.length; ++j)
            {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        int i = 0;
        int j = matrix.length-1;
        while(i < j)
        {
            for(int k = 0; k < matrix.length; ++k)
            {
                int tmp = matrix[k][i];
                matrix[k][i] = matrix[k][j];
                matrix[k][j] = tmp;
            }
            ++i;
            --j;
        }
    }
}