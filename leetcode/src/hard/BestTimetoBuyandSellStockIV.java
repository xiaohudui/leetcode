package hard;

public class BestTimetoBuyandSellStockIV {
	public int maxProfit(int k, int[] prices) {
		if (prices == null || prices.length == 0)
			return 0;
		if(k>=prices.length/2){
			return helper(prices);
		}
		int[] local = new int[k + 1];
		int[] global = new int[k + 1];
		for (int i = 0; i < prices.length - 1; i++) {
			int diff = prices[i + 1] - prices[i];
			for (int j = k; j >= 1; j--) {
				local[j] = Math.max(global[j - 1] + (diff > 0 ? diff : 0), local[j] + diff);
				global[j] = Math.max(local[j], global[j]);
			}
		}
		return global[k];
	}
    int helper(int[] prices)
    {
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++)
        {
            profit = Math.max(profit, profit + prices[i + 1] - prices[i]);
        }
        return profit;
    }
    public static void main(String[] args) {
		int[] A={1,2,4,7,3,5,6,10};
		System.out.println(new BestTimetoBuyandSellStockIV().maxProfit(3, A));
	}
}
