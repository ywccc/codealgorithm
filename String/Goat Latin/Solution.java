class Solution {
    public String toGoatLatin(String S) {
        if(S == null || S.length() == 0) return S;
        String[] ss = S.split(" ");
        List<Character> help = new ArrayList<Character>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        
        String res = "";
        for(int i = 0; i < ss.length; ++i)
        {
            if(help.contains(ss[i].charAt(0)))
            {
                res += ss[i] + "ma";
            }
            else
            {
                res += ss[i].substring(1) + ss[i].charAt(0) + "ma";
            }
            for(int j = 0; j <= i; ++j)
            {
                res += "a";
            }
            res += " ";
        }
        return res.trim();
    }
}
