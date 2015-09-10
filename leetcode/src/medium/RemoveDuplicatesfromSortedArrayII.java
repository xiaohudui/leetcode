package medium;

import java.util.Arrays;

public class RemoveDuplicatesfromSortedArrayII {
	public int removeDuplicates(int[] nums) {
		if (nums.length <= 2){
			return nums.length;
		}
		int p=1;
		for (int i = 2; i < nums.length; i++) {
			if(!(nums[i]==nums[p] && nums[i]==nums[p-1])){
				p++;
				nums[p]=nums[i];
			}
		}
		return p+1;
	}
	public static void main(String[] args) {
		int[] nums = {1, 1, 1, 2, 2, 3};
		System.out.println(new RemoveDuplicatesfromSortedArrayII().removeDuplicates(nums));
		System.out.println(Arrays.toString(nums));
	}
}
