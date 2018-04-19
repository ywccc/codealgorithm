
class Solution {
    public boolean isMatch(String ss, String pp) {
        if(ss == null || pp == null ) return false;
        
        char[] s = ss.toCharArray();
        char[] p = pp.toCharArray();
        
        boolean[][] help = new boolean[s.length+1][p.length+1];
        help[0][0] = true;
        
        for(int i = 0; i < p.length; ++i)
        {
            if(p[i] == '*' && help[0][i-1]) help[0][i+1] = true;
        }
        
        for(int i = 0; i < s.length; ++i)
        {
            for(int j = 0; j < p.length; ++j)
            {
                if(p[j] == '.')
                {
                    help[i+1][j+1] = help[i][j];
                }
                else if(Character.isLetter(p[j]))
                {
                    help[i+1][j+1] = (s[i] == p[j] && help[i][j])?true:false;
                }
                else
                {
                   if(p[j-1] != s[i] && p[j-1] != '.')
                   {
                       help[i+1][j+1] = help[i+1][j-1];
                   }
                    else
                    {
                        help[i+1][j+1] = help[i+1][j-1] || help[i+1][j] || help[i][j+1];
                    }
                }
            }
        }
        
        return help[s.length][p.length];
        
    }
}
