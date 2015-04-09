package medium;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {
	/**
	 * 类似于八皇后问题的回溯算法，时间复杂度指数级 一：拆分单词递归 二：组合单词
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
	 * 不断判断字典中的单词是否可以成为单词的第一部分 时间复杂度O(n^2)
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
	 * 动态规划，定义一个数组，扫描所有字典单词时记录能不能合成到某个位置，当前位置通过前面不可到达时直接跳过 类比上楼梯的过程
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
	 * 正则表达式匹配法：s是这些单词的一次或多次组合，match(("hello"|"world")*)
	 * 正则匹配也会很耗时间，但是可以构造一个DFA,使得时间复杂度将为O(n)
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
