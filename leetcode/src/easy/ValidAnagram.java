package easy;

public class ValidAnagram {
	public boolean isAnagram(String s, String t) {
		int[] ss=new int[26];
		int[] tt=new int[26];
		if(s==null || t==null){
			return false;
		}
		if(s.length()!=t.length()){
			return false;
		}
		for (int i = 0; i < s.length(); i++) {
			ss[s.charAt(i)-'a']++;
			tt[t.charAt(i)-'a']++;
		}
		for (int i = 0; i < ss.length; i++) {
			if(ss[i]!=tt[i]){
				return false;
			}
		}
		return true;
	}
}
