package medium;

public class MinimumPathSum {
	/**
	 * 回溯法，超时
	 */
	public int minPathSum(int[][] grid) {
		long[] min=new long[1];
		min[0]=Integer.MAX_VALUE+1L;
		long sum=grid[0][0];
		step(grid,0,0,sum,min);
		return (int)min[0];
	}
	public void step(int[][] grid,int x,int y,long sum,long[] min){
		if(x==grid.length-1 && y==grid[0].length-1){
			min[0]=min[0]<sum?min[0]:sum;
		}else if(x==grid.length-1){
			step(grid,x,y+1,sum+grid[x][y+1],min);
		}else if(y==grid[0].length-1){
			step(grid,x+1,y,sum+grid[x+1][y],min);
		}else{
			step(grid,x,y+1,sum+grid[x][y+1],min);
			step(grid,x+1,y,sum+grid[x+1][y],min);
		}
	}
	/**
	 * 动态规划 
	 */
	public int minPathSum1(int[][] grid) {
		if(grid==null || grid.length==0	){
			return 0;
		}
		int m=grid.length;
		int n=grid[0].length;
		int[][] dp=new int[m][n];
		dp[m-1][n-1]=grid[m-1][n-1];
		for (int i = 0; i < m-1; i++) {
			dp[m-2-i][n-1]=grid[m-2-i][n-1]+dp[m-1-i][n-1];
		}
		for (int i = 0; i < n-1; i++) {
			dp[m-1][n-2-i]=grid[m-1][n-2-i]+dp[m-1][n-1-i];
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[m-1-i][n-1-j]=grid[m-1-i][n-1-j]+Math.min(dp[m-i][n-1-j], dp[m-1-i][n-j]);
			}
		}
		return dp[0][0];
	}
	
	public static void main(String[] args) {
		int[][] grid={{1,1,0},
					  {1,2,2},
					  {1,2,2}};
		System.out.println(new MinimumPathSum().minPathSum1(grid));
	}
}
