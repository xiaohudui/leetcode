package medium;

public class PermutationSequence {
	public String getPermutation(int n, int k) {
		String res = "";
		int[] nums = new int[n];
		int factorial = 1;
		for (int i = 0; i < n; i++) {
			nums[i] = i + 1;
			factorial *= i + 1;
		}
		k--;
		for (int i = 0; i < n; i++) {
			res += String.valueOf(nums[k / (factorial / (n - i))]);
			for (int j = k / (factorial / (n - i)); j < n - i - 1; j++) {
				nums[j] = nums[j + 1];
			}
			k = k % (factorial / (n - i));
			factorial/=(n-i);
		}
		return res;
	}
	public static void main(String[] args) {
		System.out.println(new PermutationSequence().getPermutation(3, 6));
	}
}
