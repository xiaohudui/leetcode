package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakII {
	/**
	 * 思路一：brute force,采用八皇后式的回退 结果：超时
	 */
	public List<String> wordBreak(String s, Set<String> wordDict) {
		ArrayList<String> res = new ArrayList<String>();
		helper(s, wordDict, 0, "", res);
		return res;
	}
	public void helper(String s, Set<String> wordDict, int start, String item, ArrayList<String> res) {
		if (start == s.length()) {
			res.add(item);
			return;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = start; i < s.length(); i++) {
			sb.append(s.charAt(i));
			if (wordDict.contains(sb.toString())) {
				String newItem = item.length() > 0 ? item + " " + sb.toString() : sb.toString();
				helper(s, wordDict, i + 1, newItem, res);
			}
		}
	}
	/**
	 * 模仿WordBreak式的逐单词进行测试 结果：超时 改进：先调用WordBreak，判断能不能break，然后再进行分割 结果：通过
	 */
	public List<String> wordBreak1(String s, Set<String> wordDict) {
		ArrayList<String> res = new ArrayList<String>();
		if (!canBreak(s, wordDict)) {
			return res;
		}
		helper1(s, wordDict, 0, "", res);
		return res;
	}
	public boolean canBreak(String s, Set<String> dict) {
		boolean[] canReach = new boolean[s.length() + 1];
		canReach[0] = true;
		for (int i = 0; i < s.length(); i++) {
			if (!canReach[i]) {
				continue;
			}
			for (String str : dict) {
				int len = str.length();
				int end = i + len;
				if (end > s.length() || canReach[end]) {
					continue;
				}
				if (s.substring(i, end).equals(str)) {
					canReach[end] = true;
				}
			}
		}
		return canReach[s.length()];
	}
	public void helper1(String s, Set<String> wordDict, int start, String item, ArrayList<String> res) {
		if (start == s.length()) {
			res.add(item);
			return;
		}
		for (String str : wordDict) {
			int len = str.length();
			int end = start + len;
			if (end > s.length()) {
				continue;
			}
			if (s.substring(start, end).equals(str)) {
				String newItem = item.length() > 0 ? item + " " + str : str;
				helper1(s, wordDict, start + len, newItem, res);
			}
		}
	}
	/**
	 * 模仿WordBreak式的逐单词进行测试，加入动态规划，跳过一些测试
	 * 结果：超时
	 * 分析：极大的增加了空间复杂度，但是时间复杂度并没有根本提高
	 */
	public List<String> wordBreak2(String s, Set<String> wordDict) {
		ArrayList<String> res = new ArrayList<String>();
		helper2(s, wordDict, 0, "", res);
		return res;
	}
	public void helper2(String s, Set<String> wordDict, int start, String item, ArrayList<String> res) {
		if (start == s.length()) {
			res.add(item);
			return;
		}
		for (String str : wordDict) {
			int len = str.length();
			int end = start + len;
			if (end > s.length()) {
				continue;
			}
			if (s.substring(start, end).equals(str)) {
				String newItem = item.length() > 0 ? item + " " + str : str;
				helper2(s, wordDict, start + len, newItem, res);
			}
		}
	}
	public static void main(String[] args) {
		String s = "catsanddog";
		String[] ss = {"cat", "cats", "and", "sand", "dog"};
		HashSet<String> set = new HashSet<String>();
		Collections.addAll(set, ss);
		System.out.println(new WordBreakII().wordBreak1(s, set));
	}
}
