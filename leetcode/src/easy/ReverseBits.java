package easy;
public class ReverseBits {
	/**
	 * 循环取最后一个bit方法(n>>i & 1)
	 * 不用判断，给某一位赋值  (res |= bit << i)
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
