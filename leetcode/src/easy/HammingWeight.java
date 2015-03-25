package easy;
public class HammingWeight {
	/**
	 * >>> �޷������ƣ���λ���㣻 
	 * >> ���� ��λ������λ�����������������ʱ��ѧ�������2
	 * << ���� ��λ���㣬��λ���� ���������������ʱ��ѧ�����2 
	 * @param n
	 * @return
	 */
	public static int hammingWeight(int n) {
		int weight = 0;
		for (int i = 0; i < 32; i++) {
			if ((n & 1) == 1) {
				weight++;
			}
			n>>>=1;
		}
		return weight;
	}
	public static void main(String[] args) {
		System.out.println(hammingWeight(11));
	}
}
