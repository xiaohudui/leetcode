package medium;

public class MaximumSubarray {
	/**
	 * 时间：O(N)
	 * 空间：O(1)
	 * @param nums
	 * @return
	 */
    public int maxSubArray(int[] nums) {
    	int local=0;
    	int global=nums[0];
    	int negtive=Integer.MIN_VALUE;
    	boolean hasPositive=false;
    	for (int i = 0; i < nums.length; i++) {
			if(nums[i]>=0){
				local+=nums[i];
				hasPositive=true;
			}else{
				global=Math.max(local, global);
				local=Math.max(local+nums[i], 0);
				negtive=Math.max(negtive, nums[i]);
			}
		}
    	global=Math.max(local, global);
    	return hasPositive?global:negtive;
    }
    /**
     *  局部最优全局最优算法
     */
    public int maxSubArray1(int[] nums) {
    	int local=nums[0];
    	int global=nums[0];
    	for (int i = 1; i < nums.length; i++) {
			local=Math.max(nums[i], local+nums[i]);
			global=Math.max(local, global);
		}
    	return global;
    }
    public static void main(String[] args) {
		int[] nums={-2,1,2,3};
		System.out.println(new MaximumSubarray().maxSubArray1(nums));
	}
}
