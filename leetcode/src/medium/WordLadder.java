package medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	/**
	 * DFS  超时
	 * 
	 * 递归：找到和当前单词相差一个字母的单词，进行dfs
	 * 找差一个字母的单词列表方法：
	 * 方法一：遍历字典，求每个词和当前单词的字母的差值
	 * 复杂度：O(M*N)	单词平均长度*字典平均长度
	 * 方法二：对当前单词的每一位进行改变后查找是否存在于字典中 
	 * 复杂度：O(M) M 为单词的平均长度
	 */
	public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
		int min = Integer.MAX_VALUE;
		wordDict.add(endWord);
		min=helper(beginWord, endWord, 1,min, wordDict);
		if (min == Integer.MAX_VALUE) {
			return 0;
		} else {
			return min;
		}
	}
	public int helper(String begin, String end,int step,int min, Set<String> dict) {
		if (begin.equals(end)) {
			return step;
		}
		if (dict.size() == 0) {
			return Integer.MAX_VALUE;
		}
		Set<String> set = new HashSet<String>(dict);
		if(set.contains(begin)){
			set.remove(begin);
		}
		Set<String> temp = nextStep(set, begin);
		for (String string : temp) {
			min = Math.min(min, helper(string, end,step + 1,min, set));
		}
		return min;
	}
	public Set<String> nextStep1(Set<String> dict, String cur) {
		Set<String> set = new HashSet<String>();
		for (String string : dict) {
			int cnt = 0;
			for (int i = 0; i < string.length(); i++) {
				if (cur.charAt(i) != string.charAt(i)) {
					cnt++;
				}
			}
			if (cnt == 1) {
				set.add(string);
			}
		}
		return set;
	}
	public Set<String> nextStep(Set<String> dict,String cur){
		Set<String> set=new HashSet<String>();
		for (int i = 0; i < cur.length(); i++) {
			char[] strArray=cur.toCharArray();
			for(char c='a';c<='z';c++){
				if(strArray[i]==c){
					continue;
				}else{
					strArray[i]=c;
					String temp=new String(strArray);
					if(dict.contains(temp)){
						set.add(temp);
					}
				}
			}
		}
		return set;
	}
	/**
	 * BFS 	QUEUE 
	 * 
	 * 思路：按层进行查找，每一层已经查找过的就直接从字典中删除，因为如果后面的用到上一层的单词，那么一定不是对端路径 
	 */
	public int ladderLength1(String beginWord, String endWord, Set<String> wordDict) {
		Queue<String> words=new LinkedList<String>();
		words.offer(beginWord);
		int step=2;
		int curCnt=1;
		int nextCnt=0;
		while(!words.isEmpty()){
			String word=words.poll();
			curCnt--;
			for (int i = 0; i < word.length(); i++) {
				char[] strArray=word.toCharArray();
				for(char c='a';c<='z';c++){
					if(strArray[i]==c){
						continue;
					}else{
						strArray[i]=c;
						String temp=new String(strArray);
						if(temp.equals(endWord)){
							return step;
						}
						if(wordDict.contains(temp)){
							words.offer(temp);
							nextCnt++;
							wordDict.remove(temp);
						}
					}
				}
			}
			if(curCnt==0){
				step++;
				curCnt=nextCnt;
				nextCnt=0;
			}
		}
		return 0;
	}
	public static void main(String[] args) {
		String start = "hit";
		String end = "cog";
		String[] dict = {"hot", "dot", "dog", "lot", "log"};
		Set<String> set = new HashSet<String>(Arrays.asList(dict));
		System.out.println(new WordLadder().ladderLength1(start, end, set));
	}
}
