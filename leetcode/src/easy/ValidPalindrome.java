package easy;
public class ValidPalindrome {
	/**
	 * ˼·1�����ַ���ת��Ϊ�ַ����飬��ת����Сд���ж��Ƿ�Ϊ����
	 * ˼·2���ֱ�������ҵ���ĸ���֣��Ƚ��Ƿ���ȣ�֪�������򽻲�
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
