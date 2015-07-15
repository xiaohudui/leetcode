package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
    		if(i>start && candidates[i]==candidates[i-1]){
    			continue;
    		}
			list.add(candidates[i]);
			helper(res,list,candidates,target,sum+candidates[i],i+1);
			list.remove(list.size()-1);
		}
    }
    public static void main(String[] args) {
    	int[] nums={10,1,2,7,6,1,5};
		System.out.println(new CombinationSumII().combinationSum2(nums, 8));
	}
}
