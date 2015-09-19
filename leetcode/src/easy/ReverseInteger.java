package easy;
public class ReverseInteger {
	public int reverse(int x) {
		long res = 0;
		boolean flag = x < 0;
		x = Math.abs(x);
		while (x > 0) {
			int digit = x % 10;
			res = res * 10 + digit;
			x /= 10;
		}
		if (res > Integer.MAX_VALUE) {
			return 0;
		} else {
			return (int) (flag ? -res : res);
		}
	}
	public static void main(String[] args) {
		System.out.println(-123 % -10);
		System.out.println(-123 / -10);
	}
}
