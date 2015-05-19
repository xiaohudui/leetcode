package test;

import medium.SurroundedRegions;

public class AreaTest {
	public static void main(String[] args) {
		char[][] board={{'X','X','X','X'},
						{'X','O','O','X'},
						{'X','X','O','X'},
						{'X','O','X','X'}};
		char[][] board1={"XOX".toCharArray(),"XOX".toCharArray(),"XOX".toCharArray()};
		new SurroundedRegions().solve2(board1);
		for (char[] cs : board1) {
			for ( char c : cs) {
				System.out.print(c);
			}
			System.out.println();
		}
	}
}
