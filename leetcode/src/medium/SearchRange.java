package medium;

import java.util.Arrays;

public class SearchRange {
	/**
	 * 二分查找，比目标大的最小值位置和比目标小的最大值位置
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] searchRange(int[] nums, int target) {
		int[] res=new int[2];
		int low=0;
		int high=nums.length-1;
		while(high>=low){
			int mid=(high+low)/2;
			if(nums[mid]>=target){
				high=mid-1;
			}else{
				low=mid+1;
			}
		}
		res[0]=high+1;
		low=0;
		high=nums.length-1;
		while(high>=low){
			int mid=(high+low)/2;
			if(nums[mid]>target){
				high=mid-1;
			}else{
				low=mid+1;
			}
		}
		res[1]=low-1;
		if(res[1]<res[0]){
			res[0]=-1;
			res[1]=-1;
		}
		return res;
	}
	public static void main(String[] args) {
		int[] nums={10};
		System.out.println(Arrays.toString(new SearchRange().searchRange(nums, 8)));
	}
}
