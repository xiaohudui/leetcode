package easy;
public class String2Integer {
	/**
	 * res = res * 10 + (str.charAt(i) - 48);���ַ������Բ��ù��ǲ����� ��flag����ʡȥ����ظ�����
	 * ����֪��ASCII��ֵ��ֻҪchar-'0'�Ϳ��Եõ�����ֵ
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
