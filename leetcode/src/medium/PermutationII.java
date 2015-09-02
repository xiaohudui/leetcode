package medium;

import java.util.ArrayList;
import java.util.List;

public class PermutationII {
	public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        helper(nums,0,res);
        return res;
    }
    public void helper(int[] nums,int start,List<List<Integer>> res){
    	if(start==nums.length){
    		arrayToList(nums, res);
    		return;
    	}
    	for (int i = start; i < nums.length; i++) {
    		if(!containsDuplicate(nums,start,i)){
    			swap(nums,start,i);
    			helper(nums,start+1,res);
    			swap(nums,start,i);
    		}
		}
    }
    public boolean containsDuplicate(int[] nums,int start,int end){
    	for (int i = start; i < end; i++) {
			if(nums[i]==nums[end]){
				return true;
			}
		}
    	return false;
    }
    public void arrayToList(int[] nums,List<List<Integer>> res){
    	List<Integer> list=new ArrayList<Integer>();
    	for (int i = 0; i < nums.length; i++) {
			list.add(nums[i]);
		}
    	res.add(list);
    }
    public void swap(int[] nums,int i,int j){
    	int temp=nums[i];
    	nums[i]=nums[j];
    	nums[j]=temp;
    }
}
