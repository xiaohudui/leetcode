package medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        int[] candidates={1,2,3,4,5,6,7,8,9};
        helper(res,new ArrayList<Integer>(),candidates,n,k,0,0);
        return res;
    }
    public void helper(List<List<Integer>> res,List<Integer> list,int[] candidates,int target,int k,int sum,int start){
    	if(sum>=target || list.size()==k){
    		if(sum==target && list.size()==k){
    			res.add(new ArrayList<Integer>(list));
    		}
    		return;
    	}
    	for (int i = start; i < candidates.length; i++) {
			list.add(candidates[i]);
			helper(res,list,candidates,target,k,sum+candidates[i],i+1);
			list.remove(list.size()-1);
		}
    }
    public static void main(String[] args) {
		System.out.println(new CombinationSumIII().combinationSum3(3, 9));
	}
}
