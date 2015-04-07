package easy;

public class PlusOne {
    public int[] plusOne(int[] digits) {
    	int N=digits.length;
        int carry=1;
        for(int i=N-1;i>=0;i--){
        	int temp=digits[i];
        	digits[i]=(temp+carry)%10;
        	carry=(temp+carry)/10;
        	if(carry==0){
        		return digits;
        	}
        }
    	int[] res=new int[N+1];
    	res[0]=1;
    	return res;
    }
}
