package easy;
public class Median {
	/**
	 * 直接遍历，寻找两数组开头的最小值,时间复杂度O(m+n)
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	public static double findMedianSortedArrays(int A[], int B[]) {
		double ans = 0;
		int N = A.length + B.length;
		if (N < 2) {
			if (N == 0) {
				return 0;
			} else if (A.length == 0) {
				return B[0];
			} else {
				return A[0];
			}
		}
		int i = 0, j = 0;
		int prev = 0, last = 0;
		while ((i + j) <= N / 2) {
			prev = last;
			if (i >= A.length) {
				last = B[j];
				j++;
			} else if (j >= B.length) {
				last = A[i];
				i++;
			} else if (A[i] > B[j]) {
				last = B[j];
				j++;
			} else {
				last = A[i];
				i++;
			}
		}
		if (N % 2 == 0) {
			ans = (prev + last) / 2.0;
		} else {
			ans = last;
		}
		return ans;
	}
	/**
	 * 二分查找，时间复杂度log(m+n)
	 * 寻找第k小数，分别找A的第k/2,和B的K/2，若A[k/2-1]< B[k/2-1]，则A的前
	 * k/2个数在我们要找的数之前,迭代
	 * 
	 * @return
	 */
	public static double solution(int A[], int B[]) {
		int m = A.length;
		int n = B.length;
		int k = m + n;
		if (k % 2 == 0) {
			return (findK(A, B, 0, 0, k / 2) + findK(A, B, 0, 0, k / 2 + 1)) / 2.0;
		} else {
			return findK(A, B, 0, 0, k / 2 + 1);
		}
	}
	public static double findK(int A[], int B[], int m, int n, int k) {
		int alen = A.length - m;
		int blen = B.length - n;
		if (alen > blen) {
			return findK(B, A, n, m, k);
		}
		if (alen == 0) {
			return B[k - 1];
		}
		if (k == 1) {
			return A[m] < B[n] ? A[m] : B[n];
		}
		int pa = alen < k / 2 ? alen : k / 2;
		int pb = k - pa;
		if (A[m + pa - 1] < B[n + pb - 1]) {
			return findK(A, B, m + pa, n, k - pa);
		} else if (A[m + pa - 1] > B[n + pb - 1]) {
			return findK(A, B, m, n + pb, k - pb);
		} else {
			return A[m + pa - 1];
		}
	}
	public static void main(String[] args) {
		int[] A = new int[]{1, 2, 3,5};
		int[] B = new int[]{4, 5, 6};
		System.out.println(findMedianSortedArrays(A, B));
	}
}
