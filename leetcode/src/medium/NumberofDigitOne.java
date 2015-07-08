package medium;

public class NumberofDigitOne {
	/**
	 * 分别统计个位，十位，百位上出现1的个数
	 * 以算百位上1为例子:   假设百位上是0, 1, 和 >=2 三种情况: 
     * case 1: n=3141092, a= 31410, b=92. 计算百位上1的个数应该为 3141 *100 次.
     * case 2: n=3141192, a= 31411, b=92. 计算百位上1的个数应该为 3141 *100 + (92+1) 次. 
     * case 3: n=3141592, a= 31415, b=92. 计算百位上1的个数应该为 (3141+1) *100 次. 
     * 
     * 注意点：i*=10会出现数组越界情况
	 */
    public int countDigitOne(int n) {
        int sum=0;
        for (long i = 1; i <= n; i*=10) {
			long a=n/i;
			long b=n%i;
			sum+=(a+8)/10*i;
			if(a%10==1){
				sum+=b+1;
			}
		}
        return sum;
    }
    public static void main(String[] args) {
		System.out.println(new NumberofDigitOne().countDigitOne(1410065408));
	}
}
