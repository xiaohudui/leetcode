package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		helper(nums, 0, res);
		return res;
	}
	public void helper(int[] nums, int start, List<List<Integer>> res) {
		if (start == nums.length) {
			arrayToList(nums, res);
			return;
		}
		for (int i = start; i < nums.length; i++) {
			if (!containsDuplicate(nums, start, i)) {
				swap(nums, start, i);
				helper(nums, start + 1, res);
				swap(nums, start, i);
			}
		}
	}
	public boolean containsDuplicate(int[] nums, int start, int end) {
		for (int i = start; i < end; i++) {
			if (nums[i] == nums[end]) {
				return true;
			}
		}
		return false;
	}
	public void arrayToList(int[] nums, List<List<Integer>> res) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			list.add(nums[i]);
		}
		res.add(list);
	}
	public void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	public static ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		ArrayList<ArrayList<Integer>> returnList = new ArrayList<ArrayList<Integer>>();
		returnList.add(new ArrayList<Integer>());

		for (int i = 0; i < num.length; i++) {
			Set<ArrayList<Integer>> currentSet = new HashSet<ArrayList<Integer>>();
			for (List<Integer> l : returnList) {
				for (int j = 0; j < l.size() + 1; j++) {
					l.add(j, num[i]);
					ArrayList<Integer> T = new ArrayList<Integer>(l);
					l.remove(j);
					currentSet.add(T);
				}
			}
			returnList = new ArrayList<ArrayList<Integer>>(currentSet);
		}

		return returnList;
	}
	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		System.out.println(new Permutations().permute(nums));
	}
}
