class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1.equals(s2)) return true;
        
        if(s1.length() != s2.length()) return false;
        HashMap<Character,Integer> help = new HashMap<Character,Integer>();
        for(int i = 0; i < s1.length(); ++i)
        {
            if(!help.containsKey(s1.charAt(i)))
            {
                help.put(s1.charAt(i),1);
            }
            else
            {
                help.put(s1.charAt(i),help.get(s1.charAt(i))+1);
            }
            if(!help.containsKey(s2.charAt(i)))
            {
                help.put(s2.charAt(i),-1);
            }
            else
            {
                help.put(s2.charAt(i),help.get(s2.charAt(i))-1);
            }
        }
        for(Character c : help.keySet())
        {
            if(help.get(c) != 0) return false;
        }
        
        for(int i = 1; i < s1.length(); ++i)
        {
            if(isScramble(s1.substring(0,i),s2.substring(0,i)) && isScramble(s1.substring(i),s2.substring(i)))
            {
                return true;
            }
            if(isScramble(s1.substring(0,i),s2.substring(s2.length()-i)) && isScramble(s1.substring(i),s2.substring(0,s2.length()-i)))
            {
                return true;
            }
        }
        return false;
    }
}