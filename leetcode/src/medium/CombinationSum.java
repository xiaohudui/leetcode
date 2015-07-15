package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        helper(res,new ArrayList<Integer>(),candidates,target,0,0);
        return res;
    }
    public void helper(List<List<Integer>> res,List<Integer> list,int[] candidates,int target,int sum,int start){
    	if(sum>=target){
    		if(sum==target){
    			res.add(new ArrayList<Integer>(list));
    		}
    		return;
    	}
    	for (int i = start; i < candidates.length; i++) {
			list.add(candidates[i]);
			helper(res,list,candidates,target,sum+candidates[i],i);
			list.remove(list.size()-1);
		}
    }
    public static void main(String[] args) {
    	int[] nums={2,3,6,7};
		System.out.println(new CombinationSum().combinationSum(nums, 7));
	}
}
