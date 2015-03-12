
public class PalindromeNumber {
	/**
	 * 数字翻转法
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
     * 利用% 和 / 来取头部和尾部
     * @param args
     */
    public static boolean isPalindrome1(int x){
    	if(x<0){
    		return false;
    	}
    	int div=1;
    	while(x/div >=10){
    		div*=10;			//和x同位数的1000....
    	}
    	while(x != 0){
    		int start = x/div;  //取头部
    		int end = x%10;		//取尾部
    		if(start != end ){
    			return false;
    		}
    		x = (x%div)/10;		//去头，去尾
    		div/=100;
    	}
    	return true;
    }
    public static void main(String[] args) {
		System.out.println(isPalindrome1(121));
	}
}
