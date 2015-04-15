package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
/**
 * 自己构造的hashmap算法往往不是最优 hash值得求解可以采用迭代的方法，不用每次都自己算一遍 每个数的hash值可以不用存下来
 * 特定的问题，系统的集合API并不一定会快
 * @author xiaohu
 *
 */
public class RepeatedDNASequences {
	public List<String> findRepeatedDnaSequences(String s) {
		List<String> list = new ArrayList<String>();
		Set<String> set = new HashSet<String>();
		Set<Integer> hashset = new HashSet<Integer>();
		// 自制简单hash表
		/*
		 * int[] ch=new int[26]; ch['A']=0; ch['C']=1; ch['G']=2; ch['T']=3;
		 */
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('A', 0);
		map.put('C', 1);
		map.put('G', 2);
		map.put('T', 3);
		if (s == null || s.length() < 10) {
			return list;
		}
		int len = s.length();
		int hash = 0;
		for (int i = 0; i < len; i++) {
			if (i < 9) {
				hash = (hash << 2) + map.get(s.charAt(i));
			} else {
				hash = (hash << 2) + map.get(s.charAt(i));
				hash &= ((1 << 20) - 1);
				if (hashset.contains(hash)) {
					set.add(s.substring(i - 9, i + 1));
				} else {
					hashset.add(hash);
				}
			}
		}
		list.addAll(set);
		return list;
	}
}
