package medium;

public class UniqueBinarySearchTrees {
	/**
	 * 递归加动态规划
	 * 不动态规划，超时
	 */
    public int numTrees(int n) {
    	int[] dp=new int[n+1];
    	dp[0]=1;
    	dp[1]=1;
    	return helper(n,dp);
    }
    public int helper(int n,int[] dp){
    	if(dp[n]!=0){
    		return dp[n];
    	}
    	int sum=0;
    	for (int i = 0; i < n; i++) {
			sum+=helper(i,dp)*helper(n-1-i,dp);
		}
    	dp[n]=sum;
    	return sum;
    }
    /**
     * 非递归解法
     * 动态规划
     */
    public int numTrees1(int n) {
    	int[] dp=new int[n+1];
    	dp[0]=1;
    	dp[1]=1;
    	for (int i = 2; i < n; i++) {
			for (int j = 0; j < i; j++) {
				dp[i]=dp[j]*dp[i-1-j];
			}
		}
    	return dp[n];
    }
    public static void main(String[] args) {
		System.out.println(new UniqueBinarySearchTrees().numTrees(19));
	}
}
