package medium;

import java.util.Arrays;

public class RemoveDuplicatesfromSortedArrayII {
    public int removeDuplicates(int[] nums) {
    	if(nums==null ||nums.length==0){
    		return 0;
    	}
    	if(nums.length==1){
    		return 1;
    	}
        int p=2;
        for (int i = 2; i < nums.length; i++) {
			if(!(nums[i]==nums[i-1] && nums[i]==nums[i-2])){
				nums[p]=nums[i];
				p++;
			}
		}
        return p;
    }
    public static void main(String[] args) {
		int[] nums={1,2,2,2,2,2,3,4,4,4};
		System.out.println(new RemoveDuplicatesfromSortedArrayII().removeDuplicates(nums));
		System.out.println(Arrays.toString(nums));
	}
}
