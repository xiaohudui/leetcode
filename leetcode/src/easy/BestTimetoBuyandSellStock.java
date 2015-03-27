package easy;

import java.util.HashMap;

public class BestTimetoBuyandSellStock {
	/**
	 * ˼·һ���ҵ����м���ֵ�ͼ�Сֵ�����Ͽ�ͷ��β������map���ڼ���ֵ��Сֵ�ҵ����Ž⣨��ʱ��
	 */
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length < 2) {
			return 0;
		}
		int maxProfit = 0;
		HashMap<Integer, Integer> peeks = new HashMap<Integer, Integer>();
		peeks.put(0, prices[0]);
		peeks.put(prices.length-1, prices[prices.length-1]);
		HashMap<Integer, Integer> bottoms = new HashMap<Integer, Integer>();
		bottoms.put(0, prices[0]);
		bottoms.put(prices.length-1, prices[prices.length-1]);
		for(int i=1; i+1 < prices.length;i++ ) {
			if ( prices[i] >= prices[i + 1] && prices[i]>=prices[i-1]) {
				peeks.put(i, prices[i]);
			}
		}
		for (int i=1 ; i+1 < prices.length;i++) {
			if (prices[i] <= prices[i + 1] && prices[i] <= prices[i - 1]) {
				bottoms.put(i, prices[i]);
			}
		}
		for (int bottom : bottoms.keySet()) {
			int bottomValue = bottoms.get(bottom);
			for (int peek : peeks.keySet()) {
				int peekValue = peeks.get(peek);
				if (bottom < peek) {
					maxProfit = maxProfit > peekValue - bottomValue ? maxProfit : peekValue - bottomValue;
				}
			}
		}
		return maxProfit;
	}
	/**
	 * ��̬�滮���洢����֮ǰ����Сֵ���ͽ����������������ά��������ֵ
	 * ����֮ǰ�ıȽϽ��
	 */
	public int maxProfit1(int[] prices) {
		if(prices==null || prices.length<2){
			return 0;
		}
		int min=prices[0];
		int maxProfit=0;
		for (int i = 1; i < prices.length; i++) {
			maxProfit=maxProfit>prices[i]-min?maxProfit:prices[i]-min;
			min=min<prices[i]?min:prices[i];
		}
		return maxProfit;
	}
}
