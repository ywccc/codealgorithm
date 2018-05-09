class Solution {
    public String minWindow(String S, String T) {
        if(S == null || S.length() == 0) return S;
        if(T == null || T.length() == 0) return T;
        
        int res = Integer.MAX_VALUE;
        int left = -1;
        for(int i = 0; i <= S.length() - T.length(); ++i)
        {
            if(S.charAt(i) == T.charAt(0))
            {
                int m = i;
                int n = 0;
                while(m < S.length())
                {
                    if(S.charAt(m) == T.charAt(n))
                    {
                        ++m;
                        ++n;
                    }
                    else
                    {
                        ++m;
                    }
                    if(n == T.length())
                    {
                        if(m-i < res)
                        {
                            res = m-i;
                            left = i;
                        }
                        break;
                    }
                }
            }
        }
        return (left == -1)?"":S.substring(left,left+res);
        
    }
}
