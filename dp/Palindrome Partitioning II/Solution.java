class Solution {
    public int minCut(String s) {
        if(s == null || s.length() <= 1) return 0;
        
        int len = s.length();
        boolean[][] help = new boolean[len][len];
        for(int i = 0; i < len; ++i) help[i][i] = true;
        for(int i = 0; i < len-1; ++i) help[i][i+1] = (s.charAt(i) == s.charAt(i+1));
        
        for(int i = 3; i <= len; ++i)
        {
            for(int j = 0; j <= len - i; ++j)
            {
                if(s.charAt(j) == s.charAt(j+i-1) && help[j+1][j+i-2]) help[j][j+i-1] = true;
            }
        }
        
        int[] res = new int[len];
        res[0] = 1;
        for(int i = 1; i < len; ++i)
        {
            if(help[0][i])
            {
                res[i] = 1;
                continue;
            }
            res[i] = Integer.MAX_VALUE;
            for(int j = 0; j < i; ++j)
            {
                if(help[j+1][i]) res[i] = Math.min(res[i],res[j]+1);
            }
        }
        return res[len-1]-1;
    }
}
