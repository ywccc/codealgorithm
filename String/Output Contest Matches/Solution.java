class Solution {
    public String findContestMatch(int n) {
        String[] help = new String[n];
        for(int i = 0; i < n; ++i)
        {
            help[i] = ""+(i+1);
        }
       while(n>1)
       {
           for(int i = 0; i < n/2; ++i)
           {
               help[i] = '('+help[i]+','+help[n-i-1]+')';
           }
           n /= 2;
       }
        return help[0];
    }
}
