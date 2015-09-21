package easy;

public class RomantoInteger {
	/**
	 * 当是 I，V,X且右侧数字比左侧大时，右减左，否则相加
	 * 
	 * @param s
	 * @return
	 */
	public int romanToInt(String s) {
		int res = 0;
		int[] map = new int[26];
		map['I' - 'A'] = 1;
		map['V' - 'A'] = 5;
		map['X' - 'A'] = 10;
		map['L' - 'A'] = 50;
		map['C' - 'A'] = 100;
		map['D' - 'A'] = 500;
		map['M' - 'A'] = 1000;
		for (int i = 0; i < s.length(); i++) {
			if (i + 1 < s.length() && map[s.charAt(i) - 'A'] < map[s.charAt(i + 1) - 'A']) {
				res -= map[s.charAt(i) - 'A'];
			} else {
				res += map[s.charAt(i) - 'A'];
			}
		}
		return res;
	}
	public static void main(String[] args) {
		RomantoInteger demo = new RomantoInteger();
		System.out.println(demo.romanToInt("MCDXXXVII"));
	}
}
