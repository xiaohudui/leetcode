package easy;

import java.util.Arrays;
/**
 * https://leetcode.com/problems/merge-sorted-array
 * @author xiaohu
 *
 */
public class MergeSortedArray {
	/**
	 * 思路一：大的往后放，可以避免频繁的移动 注意：如果B先没了，A剩下的就可以不用动了
	 */
	public void merge(int A[], int m, int B[], int n) {
		while(m>0 && n>0){
			if(A[m-1]>B[n-1]){
				A[m+n-1]=A[m-1];
				m--;
			}else{
				A[m+n-1]=B[n-1];
				n--;
			}
		}
		while(n>0){
			A[m+n-1]=B[n-1];
			n--;
		}
	}
	public static void main(String[] args) {
		int[] A = {1, 2, 3, 0, 0, 0};
		int[] B = {4, 5, 6};
		int m = 3, n = 3;
		new MergeSortedArray().merge(A, m, B, n);
		System.out.println(Arrays.toString(A));
	}
}
