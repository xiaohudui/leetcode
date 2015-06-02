package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams {
	/**
	 * 判断是否是同分异构：
	 * 1. 字符排序后相同就是异构
	 * 2. 统计单词中每个字符的出现次数，分别构成map，如果最后map相同，那么就是异构体
	 * 比较map是否相同：
	 * 取其一Map的key，对应value相同，删除另一Map对应条目
	 * 判断map是否被删空
	 */
    public List<String> anagrams(String[] strs) {
    	List<String> res=new ArrayList<String>();
    	Map<String,List<String>> anagramsMap=new HashMap<String,List<String>>();
    	for (String string : strs) {
			char[] temp=string.toCharArray();
			Arrays.sort(temp);
			String sorted=new String(temp);
			if(anagramsMap.containsKey(sorted)){
				anagramsMap.get(sorted).add(string);
			}else{
				List<String> list=new ArrayList<String>();
				list.add(string);
				anagramsMap.put(sorted, list);
			}
		}
    	for (List<String> list : anagramsMap.values()) {
			if(list.size()>1){
				res.addAll(list);
			}
		}
    	return res;
    }
}
