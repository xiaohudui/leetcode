package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
	/**
	 * 思路二：选定target时，不选重复的，因为和该target配套的twosum对都已经找到了，找twosum对时也略过重复的
	 */
	public ArrayList<ArrayList<Integer>> threeSum1(int[] nums){
	    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	    if(nums==null || nums.length<=2){
	        return res;
	    }
	    Arrays.sort(nums);
	    for(int i=nums.length-1;i>=2;i--){
	        if(i<nums.length-1 && nums[i]==nums[i+1]){
	        	continue;
	        }
	         ArrayList<ArrayList<Integer>> curRes = twoSum(nums,i-1,-nums[i]);
	         for(int j=0;j<curRes.size();j++){
	             curRes.get(j).add(nums[i]);
	         }
	         res.addAll(curRes);
	    }
	    return res;
	}
	private ArrayList<ArrayList<Integer>> twoSum(int[] nums, int end,int target){
	    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	    if(nums==null || nums.length<=1)
	        return res;
	    int l = 0;
	    int r = end;
	    while(l<r){
	        if(nums[l]+nums[r]==target){
	            ArrayList<Integer> item = new ArrayList<Integer>();
	            item.add(nums[l]);
	            item.add(nums[r]);
	            res.add(item);
	            l++;
	            r--;
	            while(l<r&&nums[l]==nums[l-1]){
	                l++;
	            }
	            while(l<r&&nums[r]==nums[r+1]){
	                r--;
	            }
	        }
	        else if(nums[l]+nums[r]>target){
	            r--;
	        }
	        else{
	            l++;
	        }
	    }
	    return res;
	}
	/**
	 * 思路一：转化为twosum，利用set去重
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> threeSum(int[] nums) {
		HashSet<Triple> set = new HashSet<Triple>();
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			int target = 0 - nums[i];
			twoSum(set, target, nums,i);
		}
		List<Integer> list;
		for (Triple t : set) {
			list=new ArrayList<Integer>();
			list.add(t.x);
			list.add(t.y);
			list.add(t.z);
			res.add(list);
		}
		return res;
	}
	void twoSum(Set<Triple> set, int target, int[] nums,int start) {
		int i=start+1,j=nums.length-1;
		while(i<j){
			if(nums[i]+nums[j]>target){
				j--;
			}else if(nums[i]+nums[j]<target){
				i++;
			}else{
				set.add(new Triple(-target,nums[i],nums[j]));
				i++;
				j--;
			}
		}
	}
	public static void main(String[] args) {
		int[] A={-1,0,1,2,-1,-4};
		List<List<Integer>> list=new ThreeSum().threeSum(A);
		System.out.println(list);
	}
}
class Triple{
	int x;
	int y;
	int z;
	Triple(int x, int y, int z) {
		int[] sorted = {x, y, z};
		Arrays.sort(sorted);
		this.x = sorted[0];
		this.y = sorted[1];
		this.z = sorted[2];
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj.getClass() != this.getClass()) {
			return false;
		}
		Triple other = (Triple) obj;
		return x == other.x && y == other.y && z == other.z;
	}
	@Override
	public int hashCode() {
		return x * 31 * 31 + y * 31 + z;
	}
}