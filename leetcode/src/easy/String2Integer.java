package easy;
public class String2Integer {
	/**
	 * res = res * 10 + (str.charAt(i) - 48);这种方法可以不用管是不是零 用flag可以省去大段重复代码
	 * 不用知道ASCII码值，只要char-'0'就可以得到数字值
	 * 
	 * @param str
	 * @return
	 */
	public int myAtoi(String str) {
		str = str.trim();
		long res = 0;
		boolean flag = false;
		if (str.startsWith("-")) {
			flag = true;
			str = str.substring(1);
		} else if (str.startsWith("+")) {
			str = str.substring(1);
		}
		for (int i = 0; i < str.length() && Character.isDigit(str.charAt(i)) && i < 11; i++) {
			res = res * 10 + (str.charAt(i) - '0');
		}
		if (res == 0) {
			return 0;
		} else if (res > Integer.MAX_VALUE) {
			return flag ? Integer.MIN_VALUE : Integer.MAX_VALUE;
		} else {
			return (int) (flag ? -res : res);
		}
	}
	public static void main(String[] args) {
	}
}
