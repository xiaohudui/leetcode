package medium;

import java.util.LinkedList;
import java.util.Queue;
/**
 * 连通图的遍历，深度遍历，每拿到一个，遍历其所在的连通图，并标记
 * @author xiaohu
 *
 */
public class NumberofIslands {
	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}
		int rowN = grid.length;
		int colN = grid[0].length;
		Queue<Integer> queue = new LinkedList<Integer>();
		int res = 0;
		boolean visit[][] = new boolean[rowN][colN];
		int[][] steps = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
		for (int i = 0; i < rowN; i++) {
			for (int j = 0; j < colN; j++) {
				if (visit[i][j] || grid[i][j] == '0') {
					continue;
				}
				res++;
				queue.add(i * colN + j);
				visit[i][j] = true;
				while (!queue.isEmpty()) {
					int k = queue.poll();
					int x = k / colN;
					int y = k % colN;
					for (int l = 0; l < 4; l++) {
						int curx = x + steps[l][0];
						int cury = y + steps[l][1];
						if (curx >= 0 && cury >= 0 && curx < rowN && cury < colN && grid[curx][cury] == '1'
								&& visit[curx][cury] == false) {
							queue.add(curx * colN + cury);
							visit[curx][cury] = true;
						}
					}
				}
			}
		}
		return res;
	}
	public static void main(String[] args) {
		char[][] grid = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'},
				{'0', '0', '0', '1', '1'}};
		System.out.println(new NumberofIslands().numIslands(grid));
	}
}
