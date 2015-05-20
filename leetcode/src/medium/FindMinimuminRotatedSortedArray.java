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
    public static void main(String[] args) {
    	int[] A={4,5,6,7,0,1,2};
    	System.out.println(new FindMinimuminRotatedSortedArray().findMin(A));
	}
}
