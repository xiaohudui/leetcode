package easy;
public class HammingWeight {
	/**
	 * >>> 无符号右移，高位补零； 
	 * >> 右移 高位补符号位，无论正负，无溢出时数学意义除以2
	 * << 左移 低位补零，高位舍弃 无论正负，无溢出时数学意义乘2 
	 * @param n
	 * @return
	 */
	public static int hammingWeight(int n) {
		int weight = 0;
		for (int i = 0; i < 32; i++) {
			if ((n & 1) == 1) {
				weight++;
			}
			n>>>=1;
		}
		return weight;
	}
	public static void main(String[] args) {
		System.out.println(hammingWeight(11));
	}
}
