import java.util.Arrays;

public class LongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
    	int max = 0;
    	int p = 0;
    	int[] chars = new int[256];
    	Arrays.fill(chars, -1);
    	for (int i = 0; i < s.length(); i++) {
			int pos=s.charAt(i);
			if(chars[pos] >= p ){
				max = max > (i - p) ? max:(i-p); 
				p = chars[pos] + 1;
			}
			chars[pos] = i;
		}
    	max = max > (s.length() - p) ? max:(s.length() - p);
    	return max;
    }
    public static void main(String[] args) {
		String s = "c";
		System.out.println(lengthOfLongestSubstring(s));
	}
}
