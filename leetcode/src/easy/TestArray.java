package easy;

import java.util.Arrays;

public class TestArray {
	public static void main(String[] args) {
		int[] Array={1,1,1,2,2,2,3,4,5,5,6,6,7,7};
		System.out.println(new RemoveDuplicatesfromSortedArray().removeDuplicates(Array));
		System.out.println(Arrays.toString(Array));
	}
}
