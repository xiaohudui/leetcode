package medium;

public class UniquePaths {
	/**
	 * 思路一：利用公式：(m+n-2)!/(m-1)!(n-1)!
	 * 问题：很快出现越界
	 */
    public int uniquePaths1(int m, int n) {
    	long factorial1=1;
    	long factorial2=1;
    	for (int i = 0; i < m-1; i++) {
			factorial1*=i+1;
			factorial2*=n+i;
		}
    	return (int)(factorial2/factorial1);
    }
    /**
     * 递归算法：超时
     */
    public int uniquePaths(int m, int n) {
    	if(m==1 || n==1){
    		return 1;
    	}
    	return uniquePaths(m-1,n)+uniquePaths(m,n-1);
    }
    /**
     * 递归即前项与后项之间有规律，有规律就可以用dp
     * 二维动态规划
     */
    public int uniquePaths2(int m,int n){
    	int[][] dp=new int[m][n];
    	for (int i = 0; i < m; i++) {
			dp[i][0]=1;
		}
    	for (int i = 0; i < n; i++) {
			dp[0][i]=1;
		}
    	for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j]=dp[i-1][j]+dp[i][j-1];
			}
		}
    	return dp[m-1][n-1];
    }
    /**
     * 一维动态规划
     */
    public int uniquePaths3(int m,int n){
    	int[] dp=new int[n];
    	for (int i = 0; i < dp.length; i++) {
			dp[i]=1;
		}
    	for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
                dp[j]+=dp[j-1];
			}
		}
    	return dp[n-1];
    }
    public static void main(String[] args) {
		System.out.println(new UniquePaths().uniquePaths2(3,4));
	}
    
}
