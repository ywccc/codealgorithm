class Solution {
    public boolean isMatch(String s, String p) {
        if(s == null) return (p == null);
        if(p == null) return (s == null);
        
        
        int m = s.length();
        int n = p.length();
        
        boolean[][] help = new boolean[m+1][n+1];
        help[0][0] = true;
        for(int i = 1; i <= m; ++i) help[i][0] = false;
        for(int j = 1; j <= n; ++j)
        {
            if(p.charAt(j-1) == '*' && help[0][j-1])
            {
                help[0][j] = true;
            }
        }
        
        for(int i = 1; i <= m; ++i)
        {
            for(int j = 1; j <= n; ++j)
            {
                if(Character.isLetter(p.charAt(j-1)))
                {
                    if(s.charAt(i-1) == p.charAt(j-1))
                    {
                        help[i][j] = help[i-1][j-1];
                    }
                }
                else if(p.charAt(j-1) == '?')
                {
                    help[i][j] = help[i-1][j-1];
                }
                else
                {
                    for(int k = 0; k <= i; ++k)
                    {
                        if(help[k][j-1])
                        {
                            help[i][j] = true;
                            break;
                        }
                    }
                }
            }
        }
        
        return help[m][n];
        
    }
}
