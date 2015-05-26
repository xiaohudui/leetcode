package medium;

public class MySqrt {
	/**
	 * 直接调用系统函数
	 */
    public int mySqrt(int x) {
    	int res=(int)Math.sqrt(x);
        return res;
    }
    /**
     * 利用二分的思想
     */
    public int mySqrt1(int x) {
    	long left=0;
    	long right=x;
    	while(left<right){
    		//特别注意虽然都用int，最终结果不会越界，但是中间结果会出现越界的情况
    		long mid=(left+right)/2;
    		if((mid+1)*(mid+1)<=x){
    			left=mid+1;
    		}else if(mid*mid>x){
    			right=mid-1;
    		}else{
    			return (int)mid;
    		}
    	}
    	return (int)left;
    }
    /**
     * 牛顿迭代公式：求 f(x)=0的解。
     * 求一个曲线与x轴的交点，就是：选定一个点，求切线和x轴的交点，然后以当前点为起点继续迭代
     * 1. x1=x0-f(x0)/f`(x0)
     * 2. 本题中 f(y)=y^2-x=0	y1=y-(y^2-x)/2y	y1=(y+x/y)/2
     * 
     * 注意点：迭代公式用double类型的计算，int类型的迭代公式会在除法时出现偏差
     */
    public int mySqrt2(int x) {
    	if(x==0){
    		return 0;
    	}
    	double lasty=0;
    	double y=1;
    	while(lasty!=y){
    		lasty=y;
    		y=(y+x/y)/2;
    	}
    	return (int)y;
    }
    public static void main(String[] args) {
		System.out.println(new MySqrt().mySqrt2(2147395599));
		System.out.println(0/(double)0);
	}
}
