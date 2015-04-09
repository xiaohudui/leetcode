package medium;
/**
 * 位运算，抑或满足交换律和结合律
 * @author xiaohu
 *
 */
public class SingleNumber {
    public int singleNumber(int[] A) {
        int res=A[0];
        for (int i = 1; i < A.length; i++) {
			res ^=A[i];
		}
        return res;
    }
}
