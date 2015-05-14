package medium;

public class FindPeakElement {
	/**
	 * 顺序查找，时间复杂度O(N) 
	 */
    public int findPeakElement(int[] nums) {
    	if(nums.length==1 || nums[0]>nums[1]){
    		return 0;
    	}
    	if(nums[nums.length-1]>nums[nums.length-2]){
    		return nums.length-1;
    	}
    	for (int i = 1; i < nums.length-1; i++) {
			if(nums[i]>nums[i-1] && nums[i]>nums[i+1]){
				return i;
			}
		}
    	return 0;
    }
    /**
     * 二分查找：时间复杂度O(logN)
     * 如果某个数mid大于其右邻，那么一定有峰值在mid左侧，否则有峰值在右侧
     */
    public int findPeakElement_binary(int[] nums) {
    	int left=0;
    	int right=nums.length-1;
    	while(left<right){
    		int mid=(left+right)/2;
    		if(nums[mid]<nums[mid+1]){
    			left=mid+1;
    		}else{
    			//注意不能用mid-1，因为可能是mid
    			right=mid;
    		}
    	}
    	return left;
    }
}
