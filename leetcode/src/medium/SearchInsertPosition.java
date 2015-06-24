package medium;

public class SearchInsertPosition {
	/**
	 * 普通查找
	 */
    public int searchInsert(int[] nums, int target) {
    	int i=0;
    	while(i<nums.length){
    		if(target<=nums[i]){
    			break;
    		}
    		i++;
    	}
    	return i;
    }
    /**
     * 二分查找到大概位置，然后分别处理
     * 注：二分查找正常是在元素存在的假设下
     */
    public int binarySearchInsert(int[] nums,int target){
    	int high=nums.length-1;
    	int low=0;
    	while(high>low+1){
    		int mid=(high+low)/2;
    		if(nums[mid]>target){
    			high=mid;
    		}else if(nums[mid]<target){
    			low=mid;
    		}else{
    			return mid;
    		}
    	}
    	if(target>nums[high]){
    		return high+1;
    	}else if(target>nums[low]){
    		return low+1;
    	}else{
    		return low;
    	}
    }
    /**
     * 不用最后判断的二分查找
     */
    public int binarySearchInsert1(int[] nums,int target){
    	int high=nums.length-1;
    	int low=0;
    	while(high>=low){
    		int mid=(high+low)/2;
    		if(nums[mid]>target){
    			high=mid-1;
    		}else if(nums[mid]<target){
    			low=mid+1;
    		}else{
    			return mid;
    		}
    	}
    	return low;
    }
}
