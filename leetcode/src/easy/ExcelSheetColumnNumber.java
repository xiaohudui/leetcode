package easy;
public class ExcelSheetColumnNumber {
	/**
	 * �򵥽���ת��
	 * @param s
	 * @return
	 */
	public int titleToNumber(String s) {
		int res =0;
		for (int i = 0; i < s.length(); i++) {
			res= res*26 +(s.charAt(i)-'A'+1);
		}
		return res;
	}
	public static void main(String[] args) {
		System.out.println(new ExcelSheetColumnNumber().titleToNumber("AA"));
	}
}
