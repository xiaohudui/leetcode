package medium;
/**
 * 思路：不限次数，那么每一次比昨天高就做一次交易
 * @author xiaohu
 *
 */
public class BestTimetoBuyandSellStockII {
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length<1){
        	return 0;
        }
        int res=0;
        for (int i = 1; i < prices.length; i++) {
			if(prices[i]>prices[i-1]){
				res+=prices[i]-prices[i-1];
			}
		}
        return res;
    }
}
