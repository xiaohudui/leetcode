package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSetsII {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		res.add(new ArrayList<Integer>());
		List<List<Integer>> curr = new ArrayList<List<Integer>>();
		int prevSize=0;
		for (int i = 0; i < nums.length; i++) {
			if (i != 0 && nums[i] == nums[i - 1]) {
				for (int j = res.size()-prevSize; j < res.size(); j++) {
					curr.add(new ArrayList<Integer>(res.get(j)));
				}
			} else {
				for (List<Integer> list : res) {
					curr.add(new ArrayList<Integer>(list));
				}
			}
			for (List<Integer> list : curr) {
				list.add(nums[i]);
			}
			prevSize=curr.size();
			res.addAll(curr);
			curr.clear();
		}
		return res;
	}
	public static void main(String[] args) {
		int[] nums={};
		System.out.println(new SubSetsII().subsetsWithDup(nums));
	}
}
