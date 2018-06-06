class Solution {
    public String customSortString(String S, String T) {
        String res = "";
        HashMap<Character,Integer> help = new HashMap<Character,Integer>();
        for(int i = 0; i < T.length(); ++i)
        {
            if(!S.contains(T.charAt(i)+""))
            {
                res += T.charAt(i);
            }
            else
            {
                if(!help.containsKey(T.charAt(i))) help.put(T.charAt(i),0);
                help.put(T.charAt(i),help.get(T.charAt(i))+1);
            }
        }
        for(int i = 0; i < S.length(); ++i)
        {
            if(help.containsKey(S.charAt(i)))
            {
                for(int j = 0; j < help.get(S.charAt(i));++j) res += S.charAt(i);
            }
        }
        return res;
    }
}
