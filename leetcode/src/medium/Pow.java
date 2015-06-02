package medium;

public class Pow {
    public double myPow(double x, int n) {
    	if(n==0){
    		return 1;
    	}
        if(n==1){
        	return x;
        }
        double product=myPow(x,Math.abs(n/2));
        if(n>0){
        	if((n&1)==1){
        		return product*product*x;
        	}else{
        		return product*product;
        	}
        }else{
        	if((n&1)==1){
        		return product==0?Double.POSITIVE_INFINITY:1.0/(product*product*x);
        	}else{
        		return product==0?Double.POSITIVE_INFINITY:1.0/(product*product);
        	}
        }
    }
    public static void main(String[] args) {
    	System.out.println(new Pow().myPow(0, -3));
    	System.out.println(Math.pow(0, -4));
	}
}
