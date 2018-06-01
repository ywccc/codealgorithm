class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] help = new int[m+1][n+1];
        for(int i = 1; i <= m; ++i)
        {
            for(int j = 1; j <= n; ++j)
            {
                help[i][j] = Math.max(help[i][j-1],help[i-1][j]);
                if(word1.charAt(i-1) == word2.charAt(j-1))
                {
                    help[i][j] = Math.max(help[i][j],help[i-1][j-1]+1);
                }
            }
        }
        return m+n-2*help[m][n];
    }
}
