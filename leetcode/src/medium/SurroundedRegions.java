package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SurroundedRegions {
	/**
	 * DFS方法，会栈溢出
	 * 
	 * @param board
	 */
	public void solve(char[][] board) {
		if (board == null || board.length == 0) {
			return;
		}
		List<Integer> island = new ArrayList<Integer>();
		int row = board.length;
		int col = board[0].length;
		boolean isSouranded = true;
		boolean[][] visited = new boolean[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (board[i][j] == 'O' && !visited[i][j]) {
					if (i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1) {
						continue;
					}
					visited[i][j] = true;
					island.add(i * col + j);
					visit(board, visited, island, i, j, isSouranded);
					if (isSouranded) {
						for (int p : island) {
							board[p / col][p % col] = 'X';
						}
					}
					island.clear();
					isSouranded = true;
				}
			}
		}
	}
	public void visit(char[][] board, boolean[][] visited, List<Integer> island, int i, int j, boolean isSouranded) {
		int[][] directs = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
		for (int[] direct : directs) {
			int x = i + direct[0];
			int y = j + direct[1];
			if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && !visited[x][y] && board[x][y] == 'O') {
				if (x == 0 || y == 0 || x == board.length - 1 || y == board[0].length - 1) {
					isSouranded = false;
					return;
				}
				visited[x][y] = true;
				island.add(x * board[0].length + y);
				visit(board, visited, island, x, y, isSouranded);
			}
		}
	}
	/**
	 * BFS算法：利用queue
	 */
	public void solve1(char[][] board) {
		if (board == null || board.length == 0) {
			return;
		}
		int[][] directs = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
		Queue<Integer> q = new LinkedList<Integer>();
		List<Integer> island = new ArrayList<Integer>();
		int row = board.length;
		int col = board[0].length;
		boolean isSouranded = true;
		boolean[][] visited = new boolean[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (board[i][j] == 'O' && !visited[i][j]) {
					isSouranded = true;
					q.offer(i * col + j);
					visited[i][j] = true;
					while (!q.isEmpty()) {
						int p = q.poll();
						island.add(p);
						int cur_x = p / col;
						int cur_y = p % col;
						for (int[] direct : directs) {
							int x = cur_x + direct[0];
							int y = cur_y + direct[1];
							if (x >= 0 && x < board.length && y >= 0 && y < board[0].length) {
								if (!visited[x][y] && board[x][y] == 'O') {
									q.offer(x * col + y);
									visited[x][y] = true;
								}
							} else {
								isSouranded = false;
							}
						}
					}
					if (isSouranded) {
						for (int p : island) {
							board[p / col][p % col] = 'X';
						}
					}
					island.clear();
				}
			}
		}
	}
	/**
	 * 只遍历边上，将所有没有被包围的O置为V，那么其余所有的O就是被包围的
	 */
	public void solve2(char[][] board) {
		if (board == null || board.length == 0) {
			return;
		}
		int row=board.length;
		int col=board[0].length;
		for (int i = 0; i < row; i++) {
			bfs(board,i,0);
			bfs(board,i,col-1);
		}
		for (int i = 0; i < col; i++) {
			bfs(board,0,i);
			bfs(board,row-1,i);
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if(board[i][j]=='O'){
					board[i][j]='X';
				}else if(board[i][j]=='V'){
					board[i][j]='O';
				}
			}
		}
	}
	public void bfs(char[][] board,int i,int j){
		if(board[i][j]!='O'){
			return;
		}
		int row=board.length;
		int col=board[0].length;
		int[][] directs = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
		Queue<Integer> q=new LinkedList<Integer>();
		q.offer(i*col+j);
		board[i][j]='V';
		while(!q.isEmpty()){
			int p=q.poll();
			for (int[] direct : directs) {
				int x=p/col+direct[0];
				int y=p%col+direct[1];
				if (x >= 0 && x < row && y >= 0 && y < col && board[x][y]=='O') {
					q.offer(x*col+y);
					board[x][y]='V';
				}
			}
		}
	}
}
