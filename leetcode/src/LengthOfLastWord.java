
public class LengthOfLastWord {
	/**
	 * 去除结尾的空格
	 * @param s
	 * @return
	 */
    public static int lengthOfLastWord(String s) {
    	int index1=s.length();
    	if(s.length()==0){
    		return index1;
    	}
    	while(index1>0 && s.charAt(index1-1)==' '){
    		index1--;
    	}
    	int index2=index1;
        while(index2>0 && s.charAt(index2-1)!=' '){
        	index2--;
        }
        return (index1-index2);
    }
    public static void main(String[] args) {
		System.out.println(lengthOfLastWord("a"));
	}
}
