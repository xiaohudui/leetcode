package easy;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        if(nums==null || nums.length==0){
            return false;
        }
    	Set<Integer> set=new HashSet<Integer>();
    	for (int i = 0; i < nums.length; i++) {
			if(set.contains(nums[i])){
				return false;
			}else{
				set.add(nums[i]);
			}
		}
    	return true;
    }
}
