package medium;

public class IntegertoRoman {
	public String intToRoman(int num) {
		String res = "";
		String[] symbol = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
		int[] value = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		for (int i = 0; i < value.length; i++) {
			while (num >= value[i]) {
				res += symbol[i];
				num -= value[i];
			}
		}
		return res;
	}
	public static void main(String[] args) {
		System.out.println(new IntegertoRoman().intToRoman(103));
	}
}
