public class Panlindrome {
	/**
	 * �����ִ����ȣ����ȫ�����ִ�
	 * 
	 * @param s
	 * @return
	 */
	public static String longestPalindrome1(String s) {
		for (int i = s.length(); i >= 1; i--) {
			for (int j = 0; j < s.length() - i + 1; j++) {
				String sub = s.substring(j, j + i);
				if (isPanlindrome(sub)) {
					return sub;
				}
			}
		}
		return null;
	}
	public static boolean isPanlindrome(String s) {
		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * ���ó���С���ִ����жϽ�����жϳ���Ϊn���ִ��Ƿ�Ϊ�ִ���ֻҪ�ж���β�Ƿ���ȣ��ͳ��ȵ�Ϊ��n-2�����ַ����Ƿ�Ϊ���ļ���
	 * 
	 * @param s
	 * @return
	 */
	public static String longestPalindrome2(String s) {
		if (s.length() == 0) {
			return "";
		}
		if (s.length() == 1) {
			return s;
		}
		boolean[][] isPanlindrome = new boolean[s.length()][s.length()];
		isPanlindrome[0][0] = true;
		for (int i = 1; i < isPanlindrome.length; i++) {
			isPanlindrome[i][i] = true;
			isPanlindrome[i][i - 1] = true;
		}
		int start = 0, end = 0;
		for (int k = 1; k < s.length(); k++) {
			for (int i = 0; k + i < s.length(); i++) {
				if (s.charAt(i) == s.charAt(i + k)) {
					isPanlindrome[i][i + k] = isPanlindrome[i + 1][i + k - 1];
					if (isPanlindrome[i][i + k]) {
						start = i;
						end = i + k;
					}
				} else {
					isPanlindrome[i][i + k] = false;
				}
			}
		}
		return s.substring(start, end + 1);
	}

	/**
	 * ԭ�����Ĵ����Ǵ�������������չ������2N-1�����������ģ�ʱ�临�Ӷ�O(n*n)
	 * 
	 * @param s
	 * @return
	 */
	public static String longestPalindrome4(String s) {
		if (s.length() == 0) {
			return "";
		}
		int max = 1, center = 0, interval = 0;
		boolean isOdd=true;
		for (int i = 0; i < s.length(); i++) {
			for (int k = 1; i - k >= 0 && i + k < s.length()
					&& s.charAt(i - k) == s.charAt(i + k); k++) {
				if ((2 * k + 1) > max) {
					center = i;
					interval = k;
					max = 2*k+1;
				}
			}
		}
		for (int i = 1; i < s.length(); i++) {
			for (int k = 1; i - k >= 0 && i + k - 1 < s.length()
					&& s.charAt(i - k) == s.charAt(i + k - 1); k++) {
				if (2 * k > max) {
					center = i;
					interval = k;
					max =2*k;
					isOdd=false;
				}
			}
		}
		if (isOdd) {
			return s.substring(center - interval, center + interval + 1);
		} else {
			return s.substring(center - interval, center + interval);
		}
	}
	public static void main(String[] args) {
		long prev = System.currentTimeMillis();
		String s = "abba";
		System.out.println(longestPalindrome4(s));
		System.out.println(System.currentTimeMillis() - prev);
	}
}
