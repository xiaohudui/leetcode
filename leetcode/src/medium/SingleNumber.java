package medium;
/**
 * λ���㣬�ֻ����㽻���ɺͽ����
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
    public static void main(String[] args) {
		int[] A={1,1,2,2,3,4,4};
		System.out.println(new SingleNumber().singleNumber(A));
	}
}
