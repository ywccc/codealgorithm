class Solution {
    public int longestValidParentheses(String s) {
        if(s == null || s.length() < 2) return 0;
        
        int[] help = new int[s.length()];  //help[i] means the largest end with i
        for(int i = 1; i < s.length(); ++i)
        {
            if(s.charAt(i) == '(')
            {
                continue;
            }
            else
            {
                if(s.charAt(i-1) == '(')
                {
                    if(i-2 < 0)
                    {
                        help[i] = 2;
                    }
                    else
                    {
                        help[i] = help[i-2] + 2;
                    }
                }
                else
                {
                    if(i - help[i-1] > 0 && s.charAt(i-help[i-1]-1) == '(')
                    {
                        if(i - help[i-1] - 2 >=0)
                        {
                            help[i] = help[i-1] + 2 + help[i-help[i-1]-2];
                        }
                        else
                        {
                            help[i] = help[i-1] + 2;
                        }
                        
                    }
                }
            }
        }
        int res = 0;
        for(int i = 0; i < help.length; ++i)
        {
            res = Math.max(res,help[i]); 
        }
        return res;
    }
}