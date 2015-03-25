package easy;
import java.util.HashMap;

public class RomantoInteger {
	/**
	 * 当是 I，V,X且右侧数字比左侧大时，右减左，否则相加
	 * @param s
	 * @return
	 */
	public int romanToInt(String s) {
		int sum = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		for (int i = 0; i < s.length(); i++) {
			if ((s.charAt(i) == 'I' || s.charAt(i) == 'X' || s.charAt(i) == 'C')
					&& (i + 1 < s.length() && map.get(s.charAt(i + 1)) > map.get(s.charAt(i)))) {
				sum += map.get(s.charAt(i + 1)) - map.get(s.charAt(i));
				i++;
			}else{
				sum+=map.get(s.charAt(i));
			}
		}
		return sum;
	}
	public static void main(String[] args) {
		RomantoInteger demo=new RomantoInteger();
		System.out.println(demo.romanToInt("MCDXXXVII"));
	}
}
