class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s == null || s.length() == 0 || k <= 0) return 0;
        HashMap<Character,Integer> help = new HashMap<Character,Integer>();
        int res = 0;
        int left = 0;
        for(int i = 0; i < s.length(); ++i)
        {
            if(help.containsKey(s.charAt(i)))
            {
                help.put(s.charAt(i),i);
            }
            else
            {
                if(help.size() < k)
                {
                    help.put(s.charAt(i),i);
                }
                else
                {
                    res = Math.max(res,i-left);
                    while(help.get(s.charAt(left))!=left)
                    {
                        ++left;
                    }
                    help.remove(s.charAt(left));
                    help.put(s.charAt(i),i);
                    ++left;
                }
            }
        }
        res = Math.max(res,s.length()-left);
        return res;
    }
}
