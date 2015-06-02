package medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	/**
	 * 思路一：判断四个方向，有路就走
	 */
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<Integer>();
		if (matrix == null || matrix.length == 0) {
			return res;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		boolean[][] visited = new boolean[m][n];
		int i = 0;
		int j = 0;
		boolean isStart = true;
		boolean hasRoute = false;
		while (true) {
			if (isStart) {
				while (j < n) {
					res.add(matrix[i][j]);
					visited[i][j] = true;
					j++;
				}
				j--;
				hasRoute = true;
			}
			isStart = false;
			while (j + 1 < n && !visited[i][j + 1]) {
				j++;
				res.add(matrix[i][j]);
				visited[i][j] = true;
				hasRoute = true;
			}
			while (j - 1 >= 0 && !visited[i][j - 1]) {
				j--;
				res.add(matrix[i][j]);
				visited[i][j] = true;
				hasRoute = true;
			}
			while (i + 1 < m && !visited[i + 1][j]) {
				i++;
				res.add(matrix[i][j]);
				visited[i][j] = true;
				hasRoute = true;
			}
			while (i - 1 >= 0 && !visited[i - 1][j]) {
				i--;
				res.add(matrix[i][j]);
				visited[i][j] = true;
				hasRoute = true;
			}
			if (!hasRoute) {
				break;
			}
			hasRoute = false;
		}
		return res;
	}
	/**
	 * 思路二：每次走四个边，然后进内圈 圈的起始元素：(i,i) 圈的个数：m/2，n/2 中较小的
	 */
	public List<Integer> spiralOrder1(int[][] matrix) {
		List<Integer> res = new ArrayList<Integer>();
		if (matrix == null || matrix.length == 0) {
			return res;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		int cycle = m < n ? (m+1) / 2 : (n+1) / 2;
		for (int i = 0; i < cycle; i++, m -= 2, n -= 2) {
			for (int j = i; j < i + n; j++) {
				res.add(matrix[i][j]);
			}
			for (int j = i+1; j < i + m; j++) {
				res.add(matrix[j][i + n - 1]);
			}
			if(m==1||n==1){
				break;
			}
			for (int j = i + n - 2; j >= i; j--) {
				res.add(matrix[i + m - 1][j]);
			}
			for (int j = i + m - 2; j > i; j--) {
				res.add(matrix[j][i]);
			}
		}
		return res;
	}
	public static void main(String[] args) {
		int[][] matrix = {{1, 2, 3},{4,5,6}};
		System.out.println(new SpiralMatrix().spiralOrder1(matrix));
	}
}
