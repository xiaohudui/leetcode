package easy;
public class FactorialTrailingZeroes {
	/**
	 * ����0�����������Ǽ�������2��5����������Сֵ�����ÿ���10�����ڽ׳���2���ӵ��������Ǳ�5��
	 * n֮ǰ��������5���ӵĸ�����n/5,�����а���25�ģ�����Ϊn/25��Ϊ����5ʱ�Ѿ��������ˣ����Բ���*2���Դ�����
	 * ע�⣺���for (int i = 5; i <=5 ; i*=5) ���ܻ�Խ��
	 * @param n
	 * @return
	 */
	public static int trailingZeroes(int n) {
		int count=0;
		for (int i = n; i >=5 ; i/=5) {
			count+=i/5;
		}
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(trailingZeroes(125));
	}
}
