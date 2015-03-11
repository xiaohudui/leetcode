public class ReverseInteger {
	public static int reverse(int x) {
		long res = 0;         //long 防止计算过程溢出
		while (x != 0) {
			res = res * 10 + x % 10;  //负数做被除数商余数都是负数（由被除数决定），所以可以定
			x = x / 10;               //取最低位
		}
		if (res > Integer.MAX_VALUE || res<Integer.MIN_VALUE) {
			return 0;
		} else {
			return (int)res;
		}
	}
	public static void main(String[] args) {
		System.out.println(reverse(-123));
		System.out.println(-123%-10);
		System.out.println(-123/-10);
	}
}
