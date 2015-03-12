
public class PalindromeNumber {
	/**
	 * ���ַ�ת��
	 * @param x
	 * @return
	 */
    public static boolean isPalindrome(int x) {
    	if (x <0){
    		return false;
    	}
        long reverse = 0;
        int p= x;
        while(x!=0){
        	reverse = reverse*10 + x%10;
        	x = x/10;
        }
        return p==reverse;
    }
    /**
     * ����% �� / ��ȡͷ����β��
     * @param args
     */
    public static boolean isPalindrome1(int x){
    	if(x<0){
    		return false;
    	}
    	int div=1;
    	while(x/div >=10){
    		div*=10;			//��xͬλ����1000....
    	}
    	while(x != 0){
    		int start = x/div;  //ȡͷ��
    		int end = x%10;		//ȡβ��
    		if(start != end ){
    			return false;
    		}
    		x = (x%div)/10;		//ȥͷ��ȥβ
    		div/=100;
    	}
    	return true;
    }
    public static void main(String[] args) {
		System.out.println(isPalindrome1(121));
	}
}
