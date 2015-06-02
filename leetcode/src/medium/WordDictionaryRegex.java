package medium;

import java.util.HashSet;
import java.util.Set;

public class WordDictionaryRegex {

	Set<String> dict=new HashSet<String>();

	public void addWord(String word) {
        dict.add(word);
    }

    /**
     * 调用系统的正则匹配函数进行，对字典中的每个单词进行匹配 
     */
    public boolean search(String word) {
        if(word.contains(".")){
        	for (String string : dict) {
				if(string.matches(word)){
					return true;
				}
			}
        	return false;
        }else{
        	return dict.contains(word);
        }
    }
    public static void main(String[] args) {
		WordDictionaryRegex dict=new WordDictionaryRegex();
		dict.addWord("hello");
		dict.addWord("world");
		System.out.println(dict.search("he..o"));
		System.out.println(dict.search("world"));
	}
}