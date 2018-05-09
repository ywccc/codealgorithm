class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        if(s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0) return 0;
        
        int count1 = 0;
        int count2 = 0;
        char[] s = s1.toCharArray();
        char[] t = s2.toCharArray();
        int i = 0;
        int j = 0;
        while(count1 < n1)
        {
            if(s[i] == t[j])
            {
                ++j;
                if(j == t.length)
                {
                    j = 0;
                    ++count2;
                }
            }
            ++i;
            if(i == s.length)
            {
                i = 0;
                ++count1;
            }
        }
        
        return count2/n2;
    }
}
