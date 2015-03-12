public class String2Integer {
	/**
	 * res = res * 10 + (str.charAt(i) - 48);这种方法可以不用管是不是零
	 * 用flag可以省去大段重复代码
	 * 不用知道ASCII码值，只要char-'0'就可以得到数字值
	 * @param str
	 * @return
	 */
	public static int atoi(String str) {
		str = str.trim();
		if (str.equals("")) {
			return 0;
		}
		if (str.charAt(0) != '+' && str.charAt(0) != '-'
				&& (str.charAt(0) < '0' || str.charAt(0) > '9')) {
			return 0;
		}
		char start = str.charAt(0);
		long res = 0;
		int i = 0;
		boolean flag = false;
		if (start == '-') {
			flag = true;
			i++;
		} else if (start == '+') {
			i++;
		}
		while (i < str.length() && (str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
			res = res * 10 + (str.charAt(i) - 48);
			if (res > Integer.MAX_VALUE) {
				if(flag){
					return Integer.MIN_VALUE;
				}else{
					return Integer.MAX_VALUE;
				}
			}
			i++;
		}
		if(flag){
			return (int)(-res);
		}else{
			return (int)(res);
		}
	}
	public static void main(String[] args) {
		System.out.println(atoi("-1"));
	}
}
