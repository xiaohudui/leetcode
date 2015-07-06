package easy;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
	/**
	 * 考察思考的严密性，注意第一个，最后一个，唯一的一个，一个也没有等情况。
	 * 区别对待最后一个，
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
	/**
	 * 简洁算法
	 */
	public List<String> summaryRanges1(int[] nums) {
		List<String> res = new ArrayList<String>();
		if (nums == null || nums.length == 0) {
			return res;
		}
		int i=0,j=1;
		while(i<nums.length){
			j=1;
			while(i+j<nums.length && nums[i+j]-nums[i]==j){
				j++;
			}
			if(j==1){
				res.add(String.valueOf(nums[i]));
			}else{
				res.add(String.valueOf(nums[i])+"->"+String.valueOf(nums[i+j-1]));
			}
			i+=j;
		}
		return res;
	}
	public static void main(String[] args) {
		int[] nums = {1,2};
		System.out.println(new SummaryRanges().summaryRanges1(nums));
	}
}
