package medium;

import java.util.TreeSet;

public class ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    	TreeSet<Integer> treeSet=new TreeSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
        	Integer floor=treeSet.floor(nums[i]);
        	Integer ceiling=treeSet.ceiling(nums[i]);
			if(floor!=null && floor+t>=nums[i] ||ceiling!=null &&ceiling-t<=nums[i]){
				return true;
			}
			treeSet.add(nums[i]);
			if(i>=k){
				treeSet.remove(nums[i-k]);
			}
		}
        return false;
    }
}
