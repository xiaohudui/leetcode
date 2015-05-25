package foundation.sort;

public class QuickSort implements Sort {
	public void sort(int[] nums) {
		sort(nums, 0, nums.length - 1);
	}
	public void sort(int[] nums, int l, int r) {
		if (l == r) {
			return;
		}
		int i = l;
		int j = r;
		int axis = nums[l];
		while (i < j) {
			while (i < j && nums[j] >= axis) {
				j--;
			}
			if(i<j){
				nums[i++] = nums[j];
			}
			while (i < j && nums[i] <= axis) {
				i++;
			}
			if(i<j){
				nums[j--] = nums[i];
			}
		}
		nums[i] = axis;
		sort(nums, l, i - 1);
		sort(nums, j + 1, r);
	}
}
