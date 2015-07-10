package hard;

public class PalindromePartitioningII {
	/**
	 * 类似于八皇后，拼词等，递归解决，复杂度指数级
	 * 
	 * @param s
	 * @return
	 */
	public int minCut(String s) {
		int len = s.length();
		boolean[][] isPalin = new boolean[len][len];
		initPalin(s, isPalin);
		int[] min = {Integer.MAX_VALUE, 0};
		helper(isPalin, 0, min);
		return min[0] - 1;
	}
	public void helper(boolean[][] isPalin, int start, int[] min) {
		if (start == isPalin.length) {
			min[0] = min[0] < min[1] ? min[0] : min[1];
			return;
		}
		for (int i = start; i < isPalin.length; i++) {
			if (isPalin[start][i]) {
				min[1]++;
				helper(isPalin, i + 1, min);
				min[1]--;
			}
		}
	}
	public void initPalin(String s, boolean[][] isPalin) {
		int len = s.length();
		for (int i = len - 1; i >= 0; i--) {
			for (int j = i; j < len; j++) {
				if (s.charAt(i) == s.charAt(j) && (j - i < 2 || isPalin[i + 1][j - 1])) {
					isPalin[i][j] = true;
				}
			}
		}
	}
	/**
	 * 动态规划：复杂度O(N*N)
	 */
	public int minCut1(String s) {
		int len = s.length();
		boolean[][] isPalin = new boolean[len][len];
		int[] min = new int[len + 1];
		for (int i = 0; i < min.length; i++) {
			min[i] = len - i;
		}
		for (int i = len - 1; i >= 0; i--) {
			for (int j = i; j < len; j++) {
				if (s.charAt(i) == s.charAt(j) && (j - i < 2 || isPalin[i + 1][j - 1])) {
					isPalin[i][j] = true;
					min[i] = Math.min(min[i], min[j + 1] + 1);
				}
			}
		}
		return min[0] - 1;
	}
	public static void main(String[] args) {
		System.out.println(new PalindromePartitioningII().minCut1("abcd"));
	}
}
