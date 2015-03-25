package easy;
public class RegularExpressionMatch {
	public static boolean isMatch(String s,String p){
		if(p.equals("")){
			return s.equals("");
		}
		if(p.length() == 1 || p.charAt(1)!='*'){
			if(s.length()<1 || (s.charAt(0)!=p.charAt(0) && p.charAt(0)!='.')){
				return false;
			}
			return isMatch(s.substring(1),p.substring(1));
		}else{
			int len=s.length();
			int i=0;
			while(i<len && (p.charAt(0)=='.' || p.charAt(0) == s.charAt(i))){
				if(isMatch(s.substring(i+1),p.substring(2))){
					i++;
				}
			}
			return false;
		}
	}
	public static void main(String[] args) {
		System.out.println(isMatch("hello",".*lo"));
	}
}
