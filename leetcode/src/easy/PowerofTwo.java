package easy;

public class PowerofTwo {
	/**
	 * 有且仅有一个1
	 * @param n
	 * @return
	 */
    public boolean isPowerOfTwo(int n) {
    	if(n<0){
    		return false;
    	}
    	int bitSum=0;
    	for (int i = 0; i < 32; i++) {
			bitSum+=((n>>i)&1);
		}
    	return bitSum==1;
    }
    
    /**
     * 经过减一后所有的1全部变为0，有了一个1后就不会继续借位，所以有且仅有一个1
     */
    public boolean isPowerOfTwo1(int n) {
    	if(n<=0){
    		return false;
    	}
    	return (n&(n-1))==0;
    }
    public static void main(String[] args) {
    	System.out.println(new PowerofTwo().isPowerOfTwo(0));
	}
}
