package medium;

public class FindMinimuminRotatedSortedArray {
	/**
	 * 二分查找，初始左端大于右端，中间值大于右端，则最小值定在中间+1和右端之间，否则在中端和左侧之间，跌点首次出现递增时左端即为最小值
	 * @param nums
	 * @return
	 */
    public int findMin(int[] nums) {
    	if(nums==null || nums.length==0){
    		return 0;
    	}
    	int l=0;
    	int r=nums.length-1;
    	int m=(l+r)/2;
    	while(l<r){
    		if(nums[l]>nums[r] && nums[m]>nums[r]){
    			l=m+1;
    		}else if(nums[l]>nums[r] && nums[m]<nums[r]){
    			r=m;
    		}else{
    			return nums[l];
    		}
    		m=(l+r)/2;
    	}
    	return nums[l];
    }
    /**
     * 根据左右半边分别递增，如果左边大于中间值，那么最小值一定在左边和中间值之间
     * 否则，左边元素就是左半边的最小值，然后去找右半边的最小值
     */
    public int findMin1(int[] nums) {
    	if(nums==null || nums.length==0){
    		return 0;
    	}
    	int l=0;
    	int r=nums.length-1;
    	int m=(l+r)/2;
    	int min=nums[0];
    	while(l<=r){
    		if(nums[l]<nums[m]){
    			min=Math.min(min, nums[l]);
    			l=m+1;
    		}else if(nums[l]>nums[m]){
    			min=Math.min(min, nums[m]);
    			r=m-1;
    		}else{
    			min=Math.min(min, Math.min(nums[l], nums[r]));
    			break;
    		}
    		m=(l+r)/2;
    	}
    	return min;
    }
    public static void main(String[] args) {
    	int[] A={2,3,1};
    	System.out.println(new FindMinimuminRotatedSortedArray().findMin1(A));
	}
}
