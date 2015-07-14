package medium;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
    	List<List<Integer>> res=new ArrayList<List<Integer>>();
    	helper(res,new ArrayList<Integer>(),n,k,1);
    	return res;
    }
    public void helper(List<List<Integer>> res,List<Integer> list,int n,int k,int start){
    	if(list.size()==k){
    		List<Integer> temp=new ArrayList<Integer>(list);
    		res.add(temp);
    		return;
    	}
    	for (int i = start; i <= n; i++) {
    		list.add(i);
			helper(res,list,n,k,i+1);
			list.remove(list.size()-1);
		}
    }
    public static void main(String[] args) {
		System.out.println(new Combinations().combine(4, 2));
	}
}
