class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) return 0;
        int[] sell = new int[prices.length]; // no stock on i-th day
        int[] buy = new int [prices.length]; // have stock on i-th day
        
        sell[0] = 0;
        buy[0] = -prices[0];
        for(int i = 1; i < prices.length; ++i)
        {
            buy[i] = Math.max(((i>1)?sell[i-2]:0) - prices[i], buy[i-1]);
            sell[i] = Math.max(sell[i-1], buy[i-1] + prices[i]);
        }
        return sell[prices.length-1];
     }
}