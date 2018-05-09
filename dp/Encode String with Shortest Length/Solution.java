class Solution {
    public String encode(String s) {
        if(s == null || s.length() == 0) return s;
        
        String[][] help = new String[s.length()][s.length()];
        
        for(int i = 1; i <= s.length(); ++i)
        {
            for(int j = 0; j < s.length()-i+1; ++j)
            {
                int k = i+j-1;
                if(i <= 4)
                {
                    help[j][k] = s.substring(j,k+1);
                }
                else
                {
                    help[j][k] = s.substring(j,k+1);
                    for(int t = j; t < k; ++t)
                    {
                        if(help[j][t].length() + help[t+1][k].length() < help[j][k].length())
                        {
                            help[j][k] = help[j][t] + help[t+1][k];
                        }
                    }
                    
                    String substr = s.substring(j,k+1);
                    for(int t = 0; t < substr.length(); ++t)
                    {
                        String replacestr = substr.substring(0,t+1);
                        if(replacestr != null && substr.length() % replacestr.length() == 0 && substr.replaceAll(replacestr,"").length() == 0){
                           String tmp = substr.length()/replacestr.length() + "[" + help[j][j+t] + "]";
                            if(tmp.length() < help[j][k].length())
                            {
                                help[j][k] = tmp;
                            }
                        }
                    }
                }
            }
        }
        
        return help[0][s.length()-1];
    }
}
