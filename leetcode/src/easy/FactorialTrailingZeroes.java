package easy;
public class FactorialTrailingZeroes {
	/**
	 * 计数0的数量，就是计数因子2和5的数量的最小值（不用考虑10），在阶乘中2因子的数量总是比5多
	 * n之前的数包含5因子的个数是n/5,其中有包含25的，个数为n/25因为除以5时已经计数过了，所以不用*2，以此类推
	 * 注意：如果for (int i = 5; i <=5 ; i*=5) 可能会越界
	 * @param n
	 * @return
	 */
	public static int trailingZeroes(int n) {
		int count=0;
		for (int i = n; i >=5 ; i/=5) {
			count+=i/5;
		}
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(trailingZeroes(125));
	}
}
