package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LetterCombinationsofaPhoneNumber {
	//bfs解法
    public List<String> letterCombinations(String digits) {
    	List<String> res=new ArrayList<String>();
    	if(digits==null || digits.length()==0){
    		return res;
    	}
    	Set<String> temp;
    	Set<String> set=new HashSet<String>();
    	set.add("");
    	String[] map={" ","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    	for (int i = 0; i < digits.length(); i++) {
			char c=digits.charAt(i);
			int index=c-'0';
			temp=new HashSet<String>(set);
			set.clear();
			for (int j = 0; j < map[index].length(); j++) {
				for (String string : temp) {
					set.add(string+map[index].charAt(j));
				}
			}
		}
    	res.addAll(set);
    	return res;
    }
    public static void main(String[] args) {
		System.out.println(new LetterCombinationsofaPhoneNumber().letterCombinations("23"));
	}
}
