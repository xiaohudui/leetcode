package hard;
/**
 * 关键：求取最大前缀回文
 * 暴力法：超时
 * KMP算法，
 * 构造 S=s+'#'+rev_s
 * 转化为求后缀与前缀的最大匹配长度,求next数组
 * @author xiaohu
 *
 */
public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        int index=s.length();
        while(!isPalindrome(s.substring(0,index))){
        	index--;
        }
        for (int i = index; i <s.length() ; i+=2) {
			s=s.charAt(i)+s;
		}
        return s;
    }
    public boolean isPalindrome(String s){
    	int i=0;
    	int j=s.length()-1;
    	while(i<j){
    		if(s.charAt(i++)!=s.charAt(j--)){
    			return false;
    		}
    	}
    	return true;
    }
    public String shortestPalindrome1(String s) {
    	StringBuilder sb=new StringBuilder(s);
    	sb.append('#');
    	for (int i = s.length()-1; i >=0; i--) {
			sb.append(s.charAt(i));
		}
    	int[] next=new int[sb.length()];
    	next[0]=0;
    	for (int i =1,j=0; i < next.length; i++) {
    		while(j>0 && sb.charAt(i)!=sb.charAt(j)){
    			j=next[j-1];
    		}
    		if(sb.charAt(i)==sb.charAt(j)){
    			j++;
    		}
    		next[i]=j;
		}
    	return sb.substring(s.length()+1,sb.length()-next[sb.length()-1])+s;
    	
    }
    public static void main(String[] args) {
    	System.out.println(new ShortestPalindrome().shortestPalindrome1("abcd"));
	}
}
