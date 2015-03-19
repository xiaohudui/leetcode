import java.util.HashMap;
/**
 * 其他解题思路： 
 * 1. 自建hash算法，hash查找时间复杂度O(1) 
 * 2. 排序找到连续最多的数 排序O(n log n) 一遍查找O(n) 
 * 3.拆分为左右两边，找左右两边的众数，相等，或一边不存在众数，那么另一个就是众数，否则，众数是两个之一
 * @author xiaohu
 *
 */
public class MajorityElement {
	/**
	 * 此法类似于Wordcount,聚类
	 * 
	 * @param num
	 * @return
	 */
	public int majorityElement(int[] num) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < num.length; i++) {
			if (map.containsKey(num[i])) {
				map.put(num[i], map.get(num[i]) + 1);
			} else {
				map.put(num[i], 1);
			}
		}
		int max = 0;
		int res = 0;
		for (int key : map.keySet()) {
			int value = map.get(key);
			if (value > max) {
				max = value;
				res = key;
			}
		}
		return res;
	}
	/**
	 * 投票法，（迭代方法，逐步去除）当count等于零时，candidate占一半，去掉已判断的部分后，
	 * cadinate在剩下的部分还会占据一半以上，非candidate若为最终结果，在剩下的部分中也可超过半数
	 * 
	 * @param num
	 * @return
	 */
	public int majorityElement1(int[] num) {
		int candidate = 0;
		int count = 0;
		for (int i = 0; i < num.length; i++) {
			if (count == 0) {
				candidate = num[i];
				count = 1;
			} else {
				if (candidate == num[i]) {
					count++;
				} else {
					count--;
				}
			}
		}
		return candidate;
	}
	/**
	 * 按位统计，某一位为一的个数大于n/2，那么众数该位必为1，否则就至少跟一半以上的数不一样，就不是众数
	 * 由于众数肯定存在，某一位一定会出现1比0多，或者0比1多 每一位只有两种选择，0或1,其余位只能为0
	 * 
	 * @param args
	 */
	public int majorityElement2(int[] num) {
		int[] bitCnt = new int[32];
		int res = 0;
		for (int i = 0; i < num.length; i++) {
			for (int j = 0; j < 32; j++) {
				if ((num[i] >> j & 1) == 1) {
					bitCnt[j]++;
				}
			}
		}
		for (int i = 0; i < 32; i++) {
			if (bitCnt[i] > num.length / 2) {
				res |= 1 << i;
			}
		}
		return res;
	}
	public int majorityElement3(int[] num) {
		return find(num,0,num.length);
	}
	/**
	 * 注意迭代次序，应该是从大到小迭代，而不是反过来
	 * @param num
	 * @param start
	 * @param end
	 * @return
	 */
	public Integer find(int[] num, int start, int end) {
		if(end-start==1){
			return num[start];
		}
		Integer forth=find(num, start, (end+start) / 2);
		Integer back =find(num, (end+start) / 2, end);
		if ( forth== null) {
			return back;
		} else if ( back== null) {
			return forth;
		} else if (back == forth) {
			return forth;
		} else {
			return findMax(num,back,forth,start,end);
		}
	}
	public Integer findMax(int[] num,int back,int forth,int start,int end){
		int backCnt=0,forthCnt=0;
		for (int i = start; i < end; i++) {
			if(num[i]==back){
				backCnt++;
			}else if(num[i]==forth){
				forthCnt++;
			}
		}
		if(backCnt>forthCnt){
			return back;
		}else if(backCnt<forthCnt){
			return forth;
		}else{
			return null;
		}
	}
	public static void main(String[] args) {
		int[] num = {1, 2,3,1,1};
		System.out.println(new MajorityElement().majorityElement3(num));
	}
}
