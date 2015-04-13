package medium;
/**
 * 以第一次卖出时刻进行分类，穷举所有结果
 * 思考：每一次进入循环区别，第一次允许交易晚一天，第二次允许交易早一天，之间有没有递归关系，可以用动态规划（O（N*N）超时）
 * 改进：用数组记录极大值点和极小值点，如果第一次卖出点不是极大值点就不用更新
 * 
 * @author xiaohu
 *
 */
public class BestTimetoBuyandSellStockIII {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length < 2) {
			return 0;
		}
		int n = prices.length;
		int[] record = new int[n];
		for (int i = 1; i < n - 1; i++) {
			if (prices[i] > prices[i - 1] && prices[i] >= prices[i + 1]) {
				record[i] = 1;
			}
			if (prices[i] < prices[i - 1] && prices[i] <= prices[i + 1]) {
				record[i] = -1;
			}
		}
		int res = 0;
		int sum1 = 0;
		int sum2 = 0;
		for (int i = 1; i < n; i++) {
			if ((record[i] == 1) || (i == n - 1)) {
				sum1 = maxProfitOnce(prices, record, 0, i + 1);
				if (i < n - 2) {
					sum2 = maxProfitOnce(prices, record, i + 1, n);
					res = res > (sum1 + sum2) ? res : (sum1 + sum2);
				} else {
					res = res > sum1 ? res : sum1;
				}
			}
		}
		return res;
	}
	public int maxProfitOnce(int[] prices, int[] record, int start, int end) {
		int min = prices[start];
		int maxProfit = 0;
		for (int i = start + 1; i < end; i++) {
			if ((record[i] != 0) || (i == end - 1)) {
				min = min < prices[i] ? min : prices[i];
				maxProfit = maxProfit > (prices[i] - min) ? maxProfit : (prices[i] - min);
			}
		}
		return maxProfit;
	}
	/**
	 * 思路二：双向扫描的方法 正向找出（0，i）的最大值，O(n) 反向找出（i,n）的最大值O(n) 求和计算最大值，总体O(n)
	 */
	public int maxProfit1(int[] prices) {
		if (prices == null || prices.length < 2) {
			return 0;
		}
		int n = prices.length;
		int[] imaxProfit = new int[n];
		int min = prices[0];
		int maxProfit = 0;
		for (int i = 1; i < n; i++) {
			min = min < prices[i] ? min : prices[i];
			if (maxProfit < prices[i] - min) {
				maxProfit = prices[i] - min;
			}
			imaxProfit[i] = maxProfit;
		}
		int max = prices[n - 1];
		maxProfit = 0;
		int res = imaxProfit[n - 1];
		for (int i = n - 2; i >= 2; i--) {
			max = max > prices[i] ? max : prices[i];
			maxProfit = maxProfit > (max - prices[i]) ? maxProfit : (max - prices[i]);
			res = res > (maxProfit + imaxProfit[i - 1]) ? res : (maxProfit + imaxProfit[i - 1]);
		}
		return res;
	}
	public static void main(String[] args) {
		int[] prices = {2, 1, 2, 0, 1};
		System.out.println(new BestTimetoBuyandSellStockIII().maxProfit1(prices));
	}
}
