class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices == null || prices.length < 2) return 0;
        int[][] help = new int[2][prices.length];
        int z = 0;
        if(k > prices.length/2)
        {
            int res = 0;
            for(int i = 0; i < prices.length-1; ++i)
            {
                if(prices[i+1] > prices[i])
                {
                    res += prices[i+1] - prices[i];
                }
            }
            return res;
        }
        
        for(int i = 1; i <= k; ++i)
        {
            int maxdiff = Integer.MIN_VALUE;
            for(int j = 1; j < prices.length; ++j)
            {
                maxdiff = Math.max(maxdiff,help[z][j-1] - prices[j-1]);
                help[1-z][j] = Math.max(help[1-z][j-1],maxdiff+prices[j]);
            }
            z = 1-z;
        }
        return help[z][prices.length-1];
    }
}