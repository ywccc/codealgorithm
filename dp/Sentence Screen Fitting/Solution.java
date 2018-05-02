class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        if(sentence == null || sentence.length == 0) return 0;
        int len = sentence.length;
        int[] dp = new int[len];
        int[] next = new int[len];
        int[] sum = new int[len];
        sum[0] = sentence[0].length();
        for(int i = 1; i < sentence.length; ++i)
        {
            sum[i] = sum[i-1]+1+sentence[i].length();
        }
        for(int i = 0; i < len; ++i)
        {
            int left = sum[len-1]-((i==0)?0:(sum[i-1]+1));
            dp[i] = (cols>=left)?(cols - left)/(sum[len-1]+1)+1:0;
            //System.out.println(dp[i]);
            int space = (cols > left)?((cols - left - 1) % (sum[len-1]+1)):cols;
            int k = (cols > left)?0:i;
            for(int j = k; j < len; ++j)
            {
                int tmp = (k == 0)?sum[j] : (sum[j] - sum[k-1]-1);
                if(tmp > space)
                {
                    next[i] = j;
                    break;
                }
            }
            if(cols == left)
            {
                dp[i] = 1;
                next[i] = 0;
            }
            
        }
        
        int res = 0;
        int k = 0;
        for(int i = 0; i < rows; ++i)
        {
            res += dp[k];
            k = next[k];
        }
        
        return res;
        
    }
}