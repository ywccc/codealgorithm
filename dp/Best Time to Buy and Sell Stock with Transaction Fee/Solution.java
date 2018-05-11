class Solution {
    public int maxProfit(int[] prices, int fee) {
        if(prices == null || prices.length == 0) return 0;
        long buy = Integer.MIN_VALUE; //表示持有股票,负无穷表示持有股票是不可能的
        long sell = 0;
        for(int i = 0; i < prices.length; ++i)
        {
            long tmp = buy;
            buy = Math.max(buy,sell - prices[i]);
            sell = Math.max(tmp + prices[i] - fee, sell);
        }
        return (int) sell;
    }
}
