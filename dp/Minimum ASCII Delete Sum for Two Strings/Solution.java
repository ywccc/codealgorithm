class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        if(s1 == null || s2 == null) return 0;
        int[][] help = new int[s1.length()+1][s2.length()+1];
        
        for(int j = 1; j <= s2.length(); ++j) help[0][j] = help[0][j-1]+s2.charAt(j-1);
        for(int i = 1; i <= s1.length(); ++i) help[i][0] = help[i-1][0]+s1.charAt(i-1);
        
        for(int i = 1; i <= s1.length(); ++i)
        {
            for(int j = 1; j <= s2.length(); ++j)
            {
                if(s1.charAt(i-1) == s2.charAt(j-1))
                {
                    help[i][j] = help[i-1][j-1];
                }
                else
                {
                    help[i][j] = help[i-1][j-1] + s1.charAt(i-1) + s2.charAt(j-1);
                }
                help[i][j] = Math.min(help[i][j],help[i-1][j] + s1.charAt(i-1));
                help[i][j] = Math.min(help[i][j],help[i][j-1] + s2.charAt(j-1));
            }
        }
        
        return help[s1.length()][s2.length()];
    }
}
