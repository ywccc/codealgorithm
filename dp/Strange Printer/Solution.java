class Solution {
    public int strangePrinter(String s) {
        if(s == null || s.length() == 0) return 0;
        int len = s.length();
        int[][][] help = new int[len][len][len+1];
        //for(int i = 0; i < len; ++i) help[i][i][0] = 1;
        return count(s,help,0,len-1,0);
    }
    
    public int count(String s, int[][][] help, int l, int r, int k)
    {
        if(l > r) return 0;
        if(help[l][r][k] > 0) return help[l][r][k];
        
        while(l < r && s.charAt(r-1) == s.charAt(r))
        {
            --r;
            ++k;
        }
        help[l][r][k] = count(s,help,l,r-1,0)+1;
        for(int i = l; i < r; ++i)
        {
            if(s.charAt(i) == s.charAt(r))
            {
                help[l][r][k] = Math.min(help[l][r][k], count(s,help,l,i,k+1)+count(s,help,i+1,r-1,0));
            }
        }
        return help[l][r][k];
    }
}
