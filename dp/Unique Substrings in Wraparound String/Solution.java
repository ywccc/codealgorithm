class Solution {
    public int findSubstringInWraproundString(String p) {
        if(p == null || p.length() == 0) return 0;
        int[] max = new int[26];
        int[] now = new int[26];
        
        for(int i = 0; i < p.length(); ++i)
        {
            if(i != 0 && ((p.charAt(i) - p.charAt(i-1) == 1) || (p.charAt(i) - p.charAt(i-1) == -25)))
            {
                int t = p.charAt(i) - 'a';
                now[t] = now[((t == 0)?25:t-1)]+1;
                max[t] = Math.max(max[t],now[t]);
            }
            else
            {
                int t = p.charAt(i) - 'a';
                now[t] = 1;
                max[t] = Math.max(max[t],now[t]);
            }
        }
        
        int res = 0;
        for(int i = 0; i < 26; ++i)
        {
            res += max[i];
        }
        return res;
    }
}
