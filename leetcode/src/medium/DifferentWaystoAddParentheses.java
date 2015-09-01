package medium;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaystoAddParentheses {
	public List<Integer> diffWaysToCompute(String input) {
		return helper(input);
	}

	public int compute(int left, int right, char op) {
		switch (op) {
			case '+' :
				return left + right;
			case '-' :
				return left - right;
			case '*' :
				return left * right;
			default :
				return 0;
		}
	}
	public List<Integer> helper(String input) {
		List<Integer> left = new ArrayList<Integer>();
		List<Integer> right = new ArrayList<Integer>();
		List<Integer> res = new ArrayList<Integer>();

		int i = 0;
		int val = 0;
		while (i < input.length() && Character.isDigit(input.charAt(i))) {
			val = val * 10 + input.charAt(i) - '0';
			i++;
		}
		if (i == input.length()) {
			res.add(val);
			return res;
		}
		for (int j = 0; j < input.length(); j++) {
			if (!Character.isDigit(input.charAt(j))) {
				left = helper(input.substring(0, j));
				right = helper(input.substring(j + 1, input.length()));

				for (int l : left) {
					for (int r : right) {
						res.add(compute(l, r, input.charAt(j)));
					}
				}
			}
		}
		return res;
	}
	public static void main(String[] args) {
		System.out.println(new DifferentWaystoAddParentheses().diffWaysToCompute("2*3-4*5"));
	}
}
