package easy;

public class PalindromeNumber {
	/**
	 * 数字翻转法
	 * 
	 * @param x
	 * @return
	 */
	public static boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		long reverse = 0;
		int p = x;
		while (x != 0) {
			reverse = reverse * 10 + x % 10;
			x = x / 10;
		}
		return p == reverse;
	}
	/**
	 * 利用% 和 / 来取头部和尾部
	 * 
	 * @param args
	 */
	public boolean isPalindrome1(int x) {
		if (x < 0) {
			return false;
		}
		int div = 1;
		while (div <= x / 10) {
			div *= 10;
		}
		while (div > 0 && x % 10 == x / div) {
			x = x % div / 10;
			div /= 100;
		}
		return div == 0;
	}
	public static void main(String[] args) {
		System.out.println();
	}
}
