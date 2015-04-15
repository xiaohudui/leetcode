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
	public ArrayList<ArrayList<Integer>> threeSum1(int[] num)
	{
	    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	    if(num==null || num.length<=2)
	        return res;
	    Arrays.sort(num);
	    for(int i=num.length-1;i>=2;i--)
	    {
	        if(i<num.length-1 && num[i]==num[i+1])
	            continue;
	         ArrayList<ArrayList<Integer>> curRes = twoSum(num,i-1,-num[i]);
	         for(int j=0;j<curRes.size();j++)
	         {
	             curRes.get(j).add(num[i]);
	         }
	         res.addAll(curRes);
	    }
	    return res;
	}
	private ArrayList<ArrayList<Integer>> twoSum(int[] num, int end,int target)
	{
	    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	    if(num==null || num.length<=1)
	        return res;
	    int l = 0;
	    int r = end;
	    while(l<r)
	    {
	        if(num[l]+num[r]==target)
	        {
	            ArrayList<Integer> item = new ArrayList<Integer>();
	            item.add(num[l]);
	            item.add(num[r]);
	            res.add(item);
	            l++;
	            r--;
	            while(l<r&&num[l]==num[l-1])
	                l++;
	            while(l<r&&num[r]==num[r+1])
	                r--;
	        }
	        else if(num[l]+num[r]>target)
	        {
	            r--;
	        }
	        else
	        {
	            l++;
	        }
	    }
	    return res;
	}
	/**
	 * 思路一：转化为twosum，利用set去重
	 * @param num
	 * @return
	 */
	public List<List<Integer>> threeSum(int[] num) {
		HashSet<Triple> set = new HashSet<Triple>();
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(num);
		for (int i = 0; i < num.length; i++) {
			int target = 0 - num[i];
			twoSum(set, target, num,i);
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
	void twoSum(Set<Triple> set, int target, int[] num,int start) {
		int i=start+1,j=num.length-1;
		while(i<j){
			if(num[i]+num[j]>target){
				j--;
			}else if(num[i]+num[j]<target){
				i++;
			}else{
				set.add(new Triple(-target,num[i],num[j]));
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