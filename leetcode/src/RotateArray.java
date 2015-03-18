public class RotateArray {
	/**
	 * ˼ά������i��(i+k)%N i=(i+k)%N ѭ��N�Σ�����ԭ�򣺲��ܱ�֤��������λ�ã��γ�һ��С�ıջ��� �ⷨ��1. ��ת��������
	 * 2.��ת0��k-1 3. ��תk �� n-1
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
