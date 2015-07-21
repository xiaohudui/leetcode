package medium;

public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	if(obstacleGrid==null || obstacleGrid.length==0){
    	    return 0;
    	}
    	int m=obstacleGrid.length;
    	int n=obstacleGrid[0].length;
    	if(obstacleGrid[m-1][n-1]==1){
    	    return 0;
    	}
    	int[][] dp=new int[m][n];
    	dp[m-1][n-1]=1;
    	for (int i = 0; i < n-1; i++) {
    		if(obstacleGrid[m-1][n-i-2]==0){
    			dp[m-1][n-i-2]=1;
    		}else{
    			break;
    		}
		}
    	for (int i = 0; i < m-1; i++) {
    		if(obstacleGrid[m-i-2][n-1]==0){
    			dp[m-i-2][n-1]=1;
    		}else{
    			break;
    		}
		}
    	for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if(obstacleGrid[m-i-1][n-j-1]==0){
					dp[m-i-1][n-j-1]=dp[m-i][n-j-1]+dp[m-i-1][n-j];
				}
			}
		}
    	return dp[0][0];
    }
    public static void main(String[] args) {
    	int[][] obstacleGrid={{1,1},{0,0}};
		System.out.println(new UniquePathsII().uniquePathsWithObstacles(obstacleGrid));
	}
}
