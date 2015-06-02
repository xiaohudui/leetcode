package medium;

import java.util.Stack;

public class EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < tokens.length; i++) {
			if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
				int operand1 = stack.pop();
				int operand2 = stack.pop();
				switch (tokens[i]) {
					case "+" :
						stack.push(operand2 + operand1);
						break;
					case "-" :
						stack.push(operand2 - operand1);
						break;
					case "*" :
						stack.push(operand2 * operand1);
						break;
					case "/" :
						stack.push(operand2 / operand1);
						break;
					default :
						break;
				}
			} else {
				stack.push(Integer.valueOf(tokens[i]));
			}
		}
		return stack.pop();
	}
	public static void main(String[] args) {
		String[] strs = {"2", "1", "+", "3", "*"};
		System.out.println(new EvaluateReversePolishNotation().evalRPN(strs));
	}
}
