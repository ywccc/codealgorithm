class Solution {
    public String multiply(String num1, String num2) {
        if(num1 == null || num1.length() == 0) return num1;
        if(num2 == null || num2.length() == 0) return num2;
        
        StringBuilder sb = new StringBuilder();
        int m = num1.length();
        int n = num2.length();
        int[] res = new int[m+n];
        
        for(int i = m-1; i >= 0; --i)
        {
            for(int j = n-1; j >= 0; --j)
            {
                res[i+j+1] += (num1.charAt(i) - '0')*(num2.charAt(j) - '0');
                res[i+j] += res[i+j+1]/10;
                res[i+j+1] %= 10;
            }
        }
        for(int i = 0; i < res.length; ++i) if(!(sb.length() == 0 && res[i] == 0))sb.append(res[i]);
        return (sb.length() == 0)?"0":sb.toString();
    }
}
