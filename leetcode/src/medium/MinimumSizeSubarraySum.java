package medium;

public class MinimumSizeSubarraySum {
	/**
	 * O(N*N)：依次检查第n个开头的子串
	 * 结果：超时
	 */
    public int minSubArrayLen(int s, int[] nums) {
    	int min=nums.length+1;
        for (int i = 0; i < nums.length; i++) {
        	int sum=0;
			for (int j = i; j < nums.length; j++) {
				sum+=nums[j];
				if(sum>=s){
					min=(j-i+1)<min?(j-i+1):min;
					break;
				}
			}
			if(sum<s){
				break;
			}
		}
        return min>nums.length?0:min;
    }
    /**
     * O(N*logN) 猜测多长子串能解决问题，每次判断需要O(N)
     */
    public int minSubArrayLen1(int s, int[] nums) {
    	int start=0,end=nums.length;
    	while(end<=nums.length && start<=end){
    		int mid=(start+end)/2;
    		if(canSolve(mid,s,nums)){
    			end=mid-1;
    		}else{
    			start=mid+1;
    		}
    	}
    	return end<nums.length?end+1:0;
    }
    public boolean canSolve(int len,int s,int[] nums){
    	int sum=0;
    	for (int i = 0; i < nums.length; i++) {
			sum+=nums[i];
			if(i>=len){
				sum-=nums[i-len];
			}
			if(sum>=s){
				return true;
			}
		}
    	return false;
    }
    /**
     * O(N)滑窗法，如果找到∑(start->end)>sum,(sum-start++)直到重新小于，然后移动end
     */
    public int minSubArrayLen2(int s, int[] nums) {
    	int min=nums.length+1;
    	int start=0,end=0,sum=0;
    	while(end<nums.length){
    		while(end<nums.length && sum<s){
    			sum+=nums[end];
    			end++;
    		}
    		while(sum>=s){
    			sum-=nums[start];
    			start++;
    		}
    		min=Math.min(min, end-start+1);
    	}
        return min>nums.length?0:min;
    }
    public static void main(String[] args) {
    	int[] nums={2,3,1,2,4,3};
		System.out.println(new MinimumSizeSubarraySum().minSubArrayLen1(7, nums));
	}
}
