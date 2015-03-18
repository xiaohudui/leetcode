public class RotateArray {
	/**
	 * 思维误区：i→(i+k)%N i=(i+k)%N 循环N次，错误原因：不能保证遍历所有位置（形成一个小的闭环） 解法：1. 翻转整个数组
	 * 2.翻转0到k-1 3. 翻转k 到 n-1
	 * 
	 * @param nums
	 * @param k
	 */
	public void rotate(int[] nums, int k) {
		k = k % nums.length;
		reverse(nums, 0, nums.length - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, nums.length - 1);
	}
	public void reverse(int[] nums, int start, int end) {
		int temp;
		for (int i = 0; i < (end - start + 1) / 2; i++) {
			temp = nums[start + i];
			nums[start + i] = nums[end - i];
			nums[end - i] = temp;
		}
	}
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5, 6};
		new RotateArray().rotate(nums, 2);
	}
}
