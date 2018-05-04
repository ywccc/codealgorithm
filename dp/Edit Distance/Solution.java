class Solution {
    public int minDistance(String word1, String word2) {
        if(word1 == null && word2 == null) return 0;
        if(word1 == null) return word2.length();
        if(word2 == null) return word1.length();
        
        int m = word1.length();
        int n = word2.length();
        int[][] help = new int[m+1][n+1];
        
        for(int i = 0; i <=m; ++i)
        {
            help[i][0] = i;
        }
        for(int j = 0; j <= n; ++j)
        {
            help[0][j] = j;
        }
        
        for(int i = 1; i <= m; ++i)
        {
            for(int j = 1; j <= n; ++j)
            {
                if(word1.charAt(i-1) == word2.charAt(j-1))
                {
                    help[i][j] = help[i-1][j-1];
                }
                else
                {
                    help[i][j] = 1 + Math.min(help[i-1][j-1],Math.min(help[i][j-1],help[i-1][j]));
                }
            }
        }
        
        return help[m][n];
    }
}
