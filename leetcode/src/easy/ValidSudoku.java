package easy;

public class ValidSudoku {
	/**
	 * 判断是否重复，用hash，三种规则，用三个数组
	 * 难点：如何一次完成：按行遍历，按列遍历，按格遍历
	 *
	 */
	public boolean isValidSudoku(char[][] board) {
		int N = board.length;
		int[] row = new int[N];
		int[] column = new int[N];
		int[] cell = new int[N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int rowN = board[i][j] - '1';
				int columnN = board[j][i] - '1';
				int cellN = board[i / 3 * 3 + j / 3][i % 3 * 3 + j % 3] - '1';
				if (rowN >= 0 && rowN <= 9) {
					if (row[rowN] != i + 1) {
						row[rowN] = i + 1;
					} else {
						return false;
					}
				}
				if (columnN >= 0 && columnN <= 9) {
					if (column[columnN] != i + 1) {
						column[columnN] = i + 1;
					} else {
						return false;
					}
				}
				if (cellN >= 0 && cellN <= 9) {
					if (cell[cellN] != i + 1) {
						cell[cellN] = i + 1;
					} else {
						return false;
					}
				}
			}
		}
		return true;
	}
	/**
	 * 利用位运算节省空间
	 * 利用row[i]每一位是否为一，表示该位是否在i行出现过
	 */
	public boolean isValidSudoku1(char[][] board) {
		int N=board.length;
		int[] row=new int[N];
		int[] column=new int[N];
		int[][] cell=new int[N/3][N/3];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int num=board[i][j]-'1';
				if(num>=0 && num<=8){
					if((row[i]>>num&1)!=1 && (column[j]>>num&1)!=1 && (cell[i/3][j/3]>>num&1)!=1){
						row[i] |=(1<<num);
						column[j] |=(1<<num);
						cell[i/3][j/3] |=(1<<num);
					}else{
						return false;
					}
				}
			}
		}
		return true;
	}
}
