package medium;

public class MaximumProductSubarray {
	/**
	 * 时间复杂度 O(N*N)
	 * 结果:超时
	 */
    public int maxProduct(int[] nums) {
    	int n=nums.length;
    	int[][] dp=new int[n][n];
    	int max=Integer.MIN_VALUE;
    	for (int i = 0; i < n; i++) {
			dp[i][i]=nums[i];
			max=Math.max(max, dp[i][i]);
		}
    	for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				dp[i][j]=dp[i][j-1]*nums[j];
				max=Math.max(max, dp[i][j]);
			}
		}
    	return max;
    }
    /**
     * 局部最优和全局最优法
     */
    public int maxProduct1(int[] nums){    	
    	int local=nums[0];
    	int localMin=nums[0];
    	int global=nums[0];
    	for (int i = 1; i < nums.length; i++) {
    		int temp=local;
			local=Math.max(Math.max(local*nums[i], nums[i]), localMin*nums[i]);
			localMin=Math.min(Math.min(temp*nums[i], localMin*nums[i]),nums[i]);
			global=Math.max(local, global);
		}
    	return global;
    }
    public static void main(String[] args) {
		int[] nums={2,3,-2,4};
		System.out.println(new MaximumProductSubarray().maxProduct1(nums));
	}
}
