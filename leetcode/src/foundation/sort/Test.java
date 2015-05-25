package foundation.sort;

import java.util.Arrays;
import java.util.Random;

public class Test {
	public static void main(String[] args) {
		int[] nums=new int[6];
		Random random=new Random();
		Sort s=new QuickSort();
		for (int i = 0; i < nums.length; i++) {
			nums[i]=random.nextInt(10);
		}
		nums=new int[]{1, 5, 0, 8, 5, 4};
		System.out.println(Arrays.toString(nums));
		s.sort(nums);
		System.out.println(Arrays.toString(nums));
	}
}
