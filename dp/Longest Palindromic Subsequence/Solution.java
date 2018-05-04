class Solution {
    public int longestPalindromeSubseq(String s) {
        if(s == null || s.length() == 0) return 0;
        int len = s.length();
        int[][] help = new int[len][len];
        
        for(int i = 0; i < len; ++i) help[i][i] = 1;
        for(int i = 0; i < len-1; ++i) help[i][i+1] = (s.charAt(i) == s.charAt(i+1))?2:1;
        
        for(int i = 3; i <= len; ++i)
        {
            for(int j = 0; j <= len - i; ++j)
            {
                help[j][j+i-1] = Math.max(help[j][j+i-2],help[j+1][j+i-1]);
                if(s.charAt(j) == s.charAt(i+j-1)) help[j][j+i-1] = Math.max(help[j][j+i-1],help[j+1][j+i-2]+2);
            }
        }
        return help[0][len-1];
    }
}
