class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int yesterdayPrice = prices[i - 1];
            int todayPrice = prices[i];
            if (todayPrice > yesterdayPrice) {
                maxProfit += todayPrice - yesterdayPrice;
            }
        }

        return maxProfit;
    }
}