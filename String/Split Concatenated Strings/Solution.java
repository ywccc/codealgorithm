class Solution {
    public String splitLoopedString(String[] strs) {
        String help = "";
        for(int i = 0; i < strs.length; ++i)
        {
            String tmp = new StringBuilder(strs[i]).reverse().toString();
            if(tmp.compareTo(strs[i]) > 0) strs[i] = tmp;
            help += strs[i];
        }
        
        int start = 0;
        String res = help;
        char max = 'a';
        
        for(int i = 0; i < strs.length; ++i)
        {
            int len = strs[i].length();
            start += len;
            String rever = new StringBuilder(strs[i]).reverse().toString();
            String other = help.substring(start) + help.substring(0,start-len);
            for(int j = 0; j < strs[i].length(); ++j)
            {
                if(strs[i].charAt(j) >= max)
                {
                    max = strs[i].charAt(j);
                    String s1 = strs[i].substring(j) + other + strs[i].substring(0,j);
                    String s2 = rever.substring(len-j-1) + other + rever.substring(0,len-j-1);
                    if(s1.compareTo(res) > 0) res = s1;
                    if(s2.compareTo(res) > 0) res = s2;
                }
            }
        }
        return res;
    }
}
