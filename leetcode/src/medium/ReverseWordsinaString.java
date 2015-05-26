package medium;

public class ReverseWordsinaString {
    public String reverseWords(String s) {
        String[] strs=s.trim().split("\\s+");
        String res="";
        for (int i = 0; i < strs.length; i++) {
        	if(i==0){
        		res+=strs[strs.length-1-i];
        	}else{
        		res+=" "+strs[strs.length-1-i];
        	}
		}
        return res;
    }
    public static void main(String[] args) {
		String s="   the   sky is blue  ";
		System.out.println(new ReverseWordsinaString().reverseWords(s).length());
	}
}
