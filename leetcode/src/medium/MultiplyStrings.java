package medium;

public class MultiplyStrings {
	public String multiply(String num1, String num2) {
		int[] res = new int[num1.length() + num2.length() - 1];
		for (int i = 0; i < num1.length(); i++) {
			for (int j = i; j < num2.length() + i; j++) {
				res[j] += (num1.charAt(num1.length() - i - 1) - '0') * (num2.charAt(num2.length() - (j - i) - 1) - '0');
			}
		}
		int carry = 0;
		int digit = 0;
		String str = "";
		for (int i = 0; i < res.length; i++) {
			digit = (res[i] + carry) % 10;
			carry = (res[i] + carry) / 10;
			str = digit + str;
		}
		if (carry != 0) {
			str = carry + str;
		}
		int i=0;
		while(i<str.length() && str.charAt(i)=='0'){
			i++;
		}
		return i==str.length()?"0":str.substring(i);
	}
	public static void main(String[] args) {
		System.out.println(new MultiplyStrings().multiply("0", "9999"));
		System.out.println(789 * 6789);
	}
}
