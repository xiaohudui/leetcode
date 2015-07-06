package easy;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
	/**
	 * 考察思考的严密性，注意第一个，最后一个，唯一的一个，一个也没有等情况。
	 * 区别对待最后一个，
	 * @param nums
	 * @return
	 */
	public List<String> summaryRanges(int[] nums) {
		List<String> res = new ArrayList<String>();
		if (nums == null || nums.length == 0) {
			return res;
		}
		if (nums.length == 1) {
			res.add(String.valueOf(nums[0]));
			return res;
		}
		int begin = nums[0];
		int pre = begin;
		int cur = begin;
		for (int i = 1; i < nums.length; i++) {
			cur = nums[i];
			if (cur - pre != 1) {
				if (pre == begin) {
					res.add(String.valueOf(begin));
				} else {
					res.add(String.valueOf(begin) + "->" + String.valueOf(pre));
				}
				begin = cur;
			}
			if (i == nums.length - 1) {
				if (cur - pre != 1) {
					res.add(String.valueOf(cur));
				} else {
					res.add(String.valueOf(begin) + "->" + String.valueOf(cur));
				}
			}
			pre = cur;
		}
		return res;
	}
	public static void main(String[] args) {
		int[] nums = {1,2,4};
		System.out.println(new SummaryRanges().summaryRanges(nums));
	}
}
