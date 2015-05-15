package medium;

public class WordSearch {
	public boolean exist(char[][] board, String word) {
		if (board == null || board.length == 0) {
			return false;
		}
		if (word.length() == 0) {
			return true;
		}
		int row = board.length;
		int col = board[0].length;
		int start = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (word.charAt(start) == board[i][j]) {
					//注意visited的位置，每次判断之前需要清空
					boolean[][] visited = new boolean[row][col];
					visited[i][j] = true;
					//对for循环中的递归调用不能直接 return exists(board, word, start + 1, i, j, visited)
					//会造成没有下一次判断的机会
					if (exists(board, word, start + 1, i, j, visited)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	public boolean exists(char[][] board, String word, int start, int i, int j, boolean[][] visited) {
		if (start == word.length()) {
			return true;
		}
		int[][] directs = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
		for (int[] direct : directs) {
			int x = i + direct[0];
			int y = j + direct[1];
			if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && !visited[x][y] && board[x][y] == word.charAt(start)) {
				visited[x][y] = true;
				//对for循环中的递归调用不能直接 return exists(board, word, start + 1, i, j, visited)
				//会造成没有下一次判断的机会
				if(exists(board, word, start + 1, x, y, visited)){
					return true;
				}
			}
		}
		//因为visited是全局的，所有修改方法都是本地修改，visited的状态不会随着回溯而更新，需要手动更新
		visited[i][j]=false;
		return false;
	}
	public static void main(String[] args) {
		String word="ABCESEEEFS";
		char[][] board={"ABCE".toCharArray(),"SFES".toCharArray(),"ADEE".toCharArray()};
		System.out.println(new WordSearch().exist(board,word));
	}
}
