package medium;

import java.util.Arrays;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
    	int n=nums.length-1;
    	while (n>0) {
			if(nums[n-1]<nums[n]){
				int index=indexOfTheFirstExceed(nums, n,nums[n-1]);
				int temp=nums[n-1];
				nums[n-1]=nums[index];
				nums[index]=temp;
				break;
			}
			n--;
		}
    	Arrays.sort(nums,n,nums.length);
        
    }
    public int indexOfTheFirstExceed(int[] nums,int start,int target){
    	int low=start;
    	int high=nums.length-1;
    	while(low<high-1){
    		int mid=(low+high)/2;
    		if(nums[mid]>target){
    			low=mid;
    		}else{
    			high=mid-1;
    		}
    	}
    	return nums[high]>target?high:low;
    }

    public static void main(String[] args) {
    	int[] nums={1,2,3,4,3};
    	new NextPermutation().nextPermutation(nums);
		System.out.println(Arrays.toString(nums));
	}
}
