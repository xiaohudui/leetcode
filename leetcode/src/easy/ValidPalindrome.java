package easy;
public class ValidPalindrome {
	/**
	 * 思路1：将字符串转换为字符数组，并转换大小写，判断是否为回文
	 * 思路2：分别从左右找到字母数字，比较是否相等，知道相遇或交叉
	 * @param s
	 * @return
	 */
	public boolean isPalindrome(String s) {
		int p=0,q=s.length()-1;
		while(p<q){
			while(p<q && !Character.isLetterOrDigit(s.charAt(p))){
				p++;
			}
			while(p<q && !Character.isLetterOrDigit(s.charAt(q))){
				q--;
			}
			if(Character.toLowerCase(s.charAt(p))!=Character.toLowerCase(s.charAt(q))){
				return false;
			}
			p++;
			q--;
		}
		return true;
	}
	public static void main(String[] args) {
		System.out.println(new ValidPalindrome().isPalindrome("12rac car21"));
		System.out.println(Character.toLowerCase(','));
		System.out.println(Character.isAlphabetic('1'));
	}
}
