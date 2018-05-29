class Solution {
    public String complexNumberMultiply(String a, String b) {
        int[] aa = new int[2];
        int[] bb = new int[2];
        aa = help(a);
        bb = help(b);
        int[] res = new int[2];
        res[0] = aa[0]*bb[0] - aa[1]*bb[1];
        res[1] = aa[0]*bb[1] + aa[1]*bb[0];
        //System.out.println(res[1]);
        String ans = res[0] + "+" + res[1] + "i";
        
        return ans;
    }
    
    public int[] help(String s)
    {
        int[] res = new int[2];
        int pos = s.indexOf("+");
        if(pos == -1)
        {
            res[0] = (s.charAt(0) == '-')?(0-Integer.valueOf(s.substring(1))):Integer.valueOf(s);
            return res;
        }
        else
        {
            int i = pos;
            res[0] = (s.charAt(0) == '-')?(0-Integer.valueOf(s.substring(1,i))):Integer.valueOf(s.substring(0,i));
            res[1] = (s.charAt(i+1) == '-')?(0-Integer.valueOf(s.substring(i+2,s.length()-1))):Integer.valueOf(s.substring(i+1,s.length()-1));
            
            return res;
        }
    }
}
