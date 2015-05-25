package medium;

import java.util.Arrays;

public class KthLargestElementinanArray {
	/**
	 * 直接排序：时间复杂度O(N*logN)
	 */
	public int findKthLargest(int[] nums, int k) {
		Arrays.sort(nums);
		return nums[nums.length - k];
	}
	/**
	 * 通过k次遍历查找最大值，只在当前值小于上次遍历的最大值时进行更新
	 * 难点：如果第k大的数出现重复
	 * 思路：计数上次最大值的出现次数，如果已经超过要查找的k,返回，否则更新上次最大值
	 * 时间复杂度 O(kN)
	 */
	public int findKthLargest1(int[] nums, int k) {
		int premax = Integer.MAX_VALUE;
		for (int i = 0; i < k; i++) {
			int cnt=0;
			int max = Integer.MIN_VALUE;
			for (int j = 0; j < nums.length; j++) {
				if (nums[j] >= max) {
					if(nums[j]>premax){
						continue;
					}else if (nums[j] == premax) {
						cnt++;
					}else{
						max = nums[j];
					}
				}
			}
			if(i!=0){
				i+=cnt-1;
			}
			if(i>=k){
				return premax;
			}
			premax=max;
		}
		return premax;
	}
	/**
	 * 利用快排的思想，只从一边开始找
	 */
	public int findKthLargest2(int[] nums, int k) {
		int l=0;
		int r=nums.length-1;
		while(true){
			int start=l;
			int end=r;
			int axis=nums[start];
			while (l < r) {
				while (l < r && nums[r] <= axis) {
					r--;
				}
				if (l < r) {
					nums[l++] = nums[r];
				}
				while (l < r && nums[l] >= axis) {
					l++;
				}
				if (l < r) {
					nums[r--] = nums[l];
				}
			}
			nums[l] = axis;
			if(l>k-1){
				r=l-1;
				l=start;
			}else if(l<k-1){
				l=l+1;
				r=end;
			}else{
				return nums[l];
			}
		}
	}
	public static void main(String[] args) {
		int[] nums={2,2,3,1};
		System.out.println(new KthLargestElementinanArray().findKthLargest2(nums, 1));
	}
}
