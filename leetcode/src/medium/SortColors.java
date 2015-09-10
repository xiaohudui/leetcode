package medium;

import java.util.Arrays;

public class SortColors {
	/**
	 * 思路一：计数排序，计数0，1，2出现次数，直接给数组赋值 思路二：头尾指针，交换排序，分为0和非零，然后1，和2
	 * 
	 * @param nums
	 */
	public void sortColors(int[] nums) {
		int l = 0, h = nums.length - 1;
		while (l < h) {
			if (nums[l] != 0 && nums[h] == 0) {
				nums[h] = nums[l];
				nums[l] = 0;
			}
			if (nums[l] == 0) {
				l++;
			}
			if (nums[h] != 0) {
				h--;
			}
		}
		l = nums[l] == 0 ? l + 1 : l;
		h = nums.length - 1;
		while (l < h) {
			if (nums[l] == 2 && nums[h] == 1) {
				nums[h] = nums[l];
				nums[l] = 1;
			}
			if (nums[l] == 1) {
				l++;
			}
			if (nums[h] == 2) {
				h--;
			}
		}
	}
	/**
	 * 思路：类似于快排，以1为中轴
	 * 0往前换，2往后换，1,指针向前
	 * @param nums
	 */
	public void sortColors1(int[] nums) {
		int zeroEnd = -1, twoBegin = nums.length, i = 0;
		while (i < twoBegin) {
			if (nums[i] == 0 && i != ++zeroEnd) {
				int temp = nums[i];
				nums[i] = nums[zeroEnd];
				nums[zeroEnd] = temp;
			} else if (nums[i] == 2 && i != --twoBegin) {
				int temp = nums[i];
				nums[i] = nums[twoBegin];
				nums[twoBegin] = temp;
			} else {
				i++;
			}
		}
	}
	public static void main(String[] args) {
		int[] nums = {2, 2, 0, 0, 1};
		new SortColors().sortColors1(nums);
		System.out.println(Arrays.toString(nums));
	}
}
