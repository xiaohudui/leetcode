package easy;
/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * @author xiaohu
 */
public class RemoveDuplicatesfromSortedArray {
	/**
	 * 思路：通过两个指针移动实现
	 * 思路：如果只要求返回不同的数量，不同的数量等于前后不同的数量加一A[i]!=A[i-1] count++;
	 */
    public int removeDuplicates(int[] A) {
    	if(A==null || A.length==0){
    		return 0;
    	}
        int len=1;
        for (int i = 1; i < A.length; i++) {
			if(A[i]!=A[len-1]){
				A[len]=A[i];
				len++;
			}
		}
        return len;
    }
}
