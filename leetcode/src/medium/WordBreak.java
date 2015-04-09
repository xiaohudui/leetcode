package medium;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {
	/**
	 * �����ڰ˻ʺ�����Ļ����㷨��ʱ�临�Ӷ�ָ���� һ����ֵ��ʵݹ� ������ϵ���
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
	 * �����ж��ֵ��еĵ����Ƿ���Գ�Ϊ���ʵĵ�һ���� ʱ�临�Ӷ�O(n^2)
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
	 * ��̬�滮������һ�����飬ɨ�������ֵ䵥��ʱ��¼�ܲ��ܺϳɵ�ĳ��λ�ã���ǰλ��ͨ��ǰ�治�ɵ���ʱֱ������ �����¥�ݵĹ���
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
	 * ������ʽƥ�䷨��s����Щ���ʵ�һ�λ�����ϣ�match(("hello"|"world")*)
	 * ����ƥ��Ҳ��ܺ�ʱ�䣬���ǿ��Թ���һ��DFA,ʹ��ʱ�临�ӶȽ�ΪO(n)
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
