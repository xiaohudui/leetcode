package medium;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {
	/**
	 * 递归方法，逐字符的回溯，类似八皇后的方法
	 */
	public boolean wordBreak(String s, Set<String> dict) {
		if (s == null || s.length() == 0 || dict.contains(s)) {
			return true;
		}
		for (int i = 1; i < s.length(); i++) {
			if (dict.contains(s.substring(0, i)) && wordBreak(s.substring(i), dict)) {
				return true;
			}
		}
		return false;
	}
	/**
	 * 递归方法，不断地寻找头部
	 */
	public boolean wordBreak1(String s, Set<String> dict) {
		return wordBreakHelper(s, dict, 0);
	}
	public boolean wordBreakHelper(String s, Set<String> dict, int start) {
		if (s == null || s.length() == 0 || dict.contains(s)) {
			return true;
		}
		for (String str : dict) {
			int len = str.length();
			int end = start + len;
			if (end > s.length()) {
				continue;
			}
			if (s.substring(start, end).equals(str)) {
				if (wordBreakHelper(s.substring(end), dict, end)) {
					return true;
				}
			}
		}
		return false;
	}
	/**
	 * 动态规划，检查时跳过已确定不可以到达的点
	 */
	public boolean wordBreak3(String s, Set<String> dict) {
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
	/**
	 * 将字典中的字符串拼接成正则表达式，查找的串出于其中*个
	 */
	public boolean wordBreak4(String s,Set<String> dict){
		StringBuilder sb=new StringBuilder();
		for (String str : dict) {
			sb.append(str+"|");
		}
		String pattern=sb.substring(0, sb.length()-1);
		pattern="("+pattern+")"+"*";
		boolean res=s.matches(pattern);
		return res;
	}
	public static void main(String[] args) {
		String[] dict = {"a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"};
		Set<String> set = new HashSet<String>();
		Collections.addAll(set, dict);
		System.out.println(new WordBreak().wordBreak4("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", set));
		System.out.println("helloworld".matches("(hello|world)*"));
	}
}
