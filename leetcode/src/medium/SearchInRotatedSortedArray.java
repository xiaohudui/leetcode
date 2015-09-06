package medium;

public class SearchInRotatedSortedArray {
	/**
	 * 思路一：找到rotate的位置，时间复杂度增加到O(N)
	 */
    public int search(int[] nums, int target) {
    	int N=nums.length;
        int pivot=1;
        for (int i = 1; i < N; i++) {
			if(nums[i]>=nums[i-1]){
				pivot++;
			}else{
				break;
			}
		}
        int high=N-1;
        int low=0;
        while(high>=low){
        	int mid=(high+low)/2;
        	if(nums[(mid+pivot)%N]>target){
        		high=mid-1;
        	}else if(nums[(mid+pivot)%N]<target){
        		low=mid+1;
        	}else{
        		return (mid+pivot)%N;
        	}
        }
        return -1;
    }
    /**
     * 思路二：用二分法查找循环移位的位置
     */
    public int search1(int[] nums, int target) {
    	int N=nums.length;
    	int high=N-1;
    	int low=0;
    	while(high>low){
    		int mid=(high+low)/2;
    		if(nums[mid]>nums[high]){
    			low=mid+1;
    		}else{
    			high=mid;
    		}
    	}
    	int pivot=high;
    	high=N-1;
    	low=0;
        while(high>=low){
        	int mid=(high+low)/2;
        	if(nums[(mid+pivot)%N]>target){
        		high=mid-1;
        	}else if(nums[(mid+pivot)%N]<target){
        		low=mid+1;
        	}else{
        		return (mid+pivot)%N;
        	}
        }
        return -1;
    }
    public static void main(String[] args) {
    	int[] nums={4 ,5 ,6 ,7, 0, 1, 2};
		System.out.println(new SearchInRotatedSortedArray().search1(nums, 0));
	}
}
