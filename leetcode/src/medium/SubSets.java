package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSets {
	/**
	 * 思路一：找到长度分别为1-n的子集
	 */
    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length; i++) {
			helper(res,new ArrayList<Integer>(),nums,i,0,0);
		}
        return res;
    }
    
    public void helper(List<List<Integer>> res,List<Integer> list,int[] nums,int total,int cnt,int start){
    	if(total==cnt){
    		List<Integer> temp=new ArrayList<Integer>(list);
    		if(list!=null && list.size()>0){
    			list.remove(list.size()-1);
    		}
    		res.add(temp);
    		return;
    	}
    	for (int i = start; i < nums.length; i++) {
			list.add(nums[i]);
			helper(res,list,nums,total,cnt+1,i+1);
		}
    	if(list.size()>0){
    		list.remove(list.size()-1);
    	}
    }
    /**
     * 对每个元素都有存在和不存在两种情况
     */
    public List<List<Integer>> subsets(int[] nums) {
    	Arrays.sort(nums);
    	List<List<Integer>> res=new ArrayList<List<Integer>>();
    	res.add(new ArrayList<Integer>());
    	List<List<Integer>> temp=new ArrayList<List<Integer>>();
    	for (int i = 0; i < nums.length; i++) {
    		for (List<Integer> list : res) {
				temp.add(new ArrayList<Integer>(list));
			}
			for (List<Integer> list : temp) {
				list.add(nums[i]);
			}
			res.addAll(temp);
			temp.clear();
		}
    	return res;
    }
    public static void main(String[] args) {
		int[] nums={1,2,3,4};
		List<List<Integer>> res=new ArrayList<List<Integer>>();
		new SubSets().helper(res,new ArrayList<Integer>(),nums,3,0,0);
//		System.out.println(res);
		System.out.println(new SubSets().subsets1(nums));
	}
}
