package medium;

import java.util.HashMap;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> map=new HashMap<Character,Character>();
        HashMap<Character,Character> reverse=new HashMap<Character,Character>();
        for (int i = 0; i < s.length(); i++) {
        	Character key=s.charAt(i);
        	Character value=t.charAt(i);
			if(map.get(key)==null && reverse.get(value)==null){
				map.put(key, value);
				reverse.put(value, key);
			}else if(!value.equals(map.get(key)) || !key.equals(reverse.get(value))){
				return false;
			}
		}
        return true;
    }
    public static void main(String[] args) {
		String s="ab";
		String t="aa";
		System.out.println(new IsomorphicStrings().isIsomorphic(s, t));
	}
}
