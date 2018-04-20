class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return res;
        int m = matrix.length;
        int n = matrix[0].length;
        
        int top = 0;
        int down = m-1;
        int left = 0;
        int right = n-1;
        
        while(down >= top && right >= left)
        {
            for(int i = left; i <= right; ++i)
            {
                res.add(matrix[top][i]);
            }
            ++top;
            for(int i = top; i <= down; ++i)
            {
                res.add(matrix[i][right]);
            }
            --right;
            for(int i = right; i >= left && top <= down; --i)
            {
                res.add(matrix[down][i]);
            }
            --down;
            for(int i = down;i >= top && left<= right; --i)
            {
                res.add(matrix[i][left]);
            }
            ++left;
        }
        return res;
    }
}