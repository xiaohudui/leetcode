package medium;

public class SearchInRotatedSortedArrayII {
	public boolean search(int[] nums, int target) {
		int N = nums.length;
		int high = N - 1;
		int low = 0;
		while (high >= low) {
			int mid = (high + low) / 2;
			if (nums[mid] == target) {
				return true;
			}
			if (nums[mid] > nums[low]) {
				if (target >= nums[low] && target < nums[mid]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			} else if (nums[mid] < nums[low]) {
				if (target > nums[mid] && target <= nums[high]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			} else {
				low++;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		int[] nums = {2,2, 0, 2, 2, 2};
		System.out.println(new SearchInRotatedSortedArrayII().search(nums, 0));
	}
}
