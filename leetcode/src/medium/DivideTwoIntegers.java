package medium;

public class DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
		if (dividend == Integer.MIN_VALUE && divisor == -1 || divisor == 0) {
			return Integer.MAX_VALUE;
		}
		long a = Math.abs((long)dividend);
		long b = Math.abs((long)divisor);
		int result = 0;
		while (a >= b) {
			int count = 0;
			while (a >= b << (count + 1)) {
				count++;
			}
			a -= b << count;
			result += 1 << count;
		}
		return dividend > 0 ^ divisor > 0 ? -result : result;
	}
	public static void main(String[] args) {
		System.out.println(new DivideTwoIntegers().divide(-1010369383, -2147483648));
	}
	
}
