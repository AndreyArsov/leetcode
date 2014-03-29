public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int profit = 0;
        int startOfSeq = prices[0];
        for (int i = 1; i <= prices.length; i++) {
            if (i == prices.length || prices[i] <= prices[i-1]) {
                int p = prices[i-1] - startOfSeq;
                if (p > 0) {
                    profit += p;
                }
                if (i < prices.length) {
                    startOfSeq = prices[i];
                }
            }
        }

        return profit;
    }
}