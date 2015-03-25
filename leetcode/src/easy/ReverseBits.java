package easy;
public class ReverseBits {
	/**
	 * ѭ��ȡ���һ��bit����(n>>i & 1)
	 * �����жϣ���ĳһλ��ֵ  (res |= bit << i)
	 * @param n
	 * @return
	 */
	public static int reverseBits(int n) {
		int res = 0;
		int N = 32;
		for (int i = 0; i < N; i++) {
			int bit = n >> i & 1;
			res |= bit << (N - 1 - i);
		}
		return res;
	}
	public static void main(String[] args) {
		System.out.println(reverseBits(43261596) == 964176192);
	}
}
