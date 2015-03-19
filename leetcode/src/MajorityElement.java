import java.util.HashMap;
/**
 * ��������˼·�� 
 * 1. �Խ�hash�㷨��hash����ʱ�临�Ӷ�O(1) 
 * 2. �����ҵ����������� ����O(n log n) һ�����O(n) 
 * 3.���Ϊ�������ߣ����������ߵ���������ȣ���һ�߲�������������ô��һ��������������������������֮һ
 * @author xiaohu
 *
 */
public class MajorityElement {
	/**
	 * �˷�������Wordcount,����
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
	 * ͶƱ������������������ȥ������count������ʱ��candidateռһ�룬ȥ�����жϵĲ��ֺ�
	 * cadinate��ʣ�µĲ��ֻ���ռ��һ�����ϣ���candidate��Ϊ���ս������ʣ�µĲ�����Ҳ�ɳ�������
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
	 * ��λͳ�ƣ�ĳһλΪһ�ĸ�������n/2����ô������λ��Ϊ1����������ٸ�һ�����ϵ�����һ�����Ͳ�������
	 * ���������϶����ڣ�ĳһλһ�������1��0�࣬����0��1�� ÿһλֻ������ѡ��0��1,����λֻ��Ϊ0
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
	 * ע���������Ӧ���ǴӴ�С�����������Ƿ�����
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
