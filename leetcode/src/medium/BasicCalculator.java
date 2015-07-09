package medium;

import java.util.Stack;

public class BasicCalculator {
	/**
	 * 思路：遇到右括号，就将对应的括号中的结果算出来
	 */
	public int calculate(String s) {
		Stack<Integer> nums = new Stack<Integer>();
		Stack<Character> ops = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '(') {
				ops.push(s.charAt(i));
			} else if (Character.isDigit(s.charAt(i))) {
				String num = "";
				while (i < s.length() && Character.isDigit(s.charAt(i))) {
					num += s.charAt(i);
					i++;
				}
				nums.push(Integer.parseInt(num));
				i--;
			} else if (s.charAt(i) == ')') {
				Stack<Character> temp1 = new Stack<Character>();
				Stack<Integer> temp2 = new Stack<Integer>();
				char op = ops.pop();
				while (op != '(') {
					temp1.push(op);
					temp2.push(nums.pop());
					op = ops.pop();
				}
				temp2.push(nums.pop());
				while (!temp1.empty()) {
					op = temp1.pop();
					if (op == '+') {
						temp2.push(temp2.pop() + temp2.pop());
					} else if (op == '-') {
						temp2.push(temp2.pop() - temp2.pop());
					}
				}
				nums.push(temp2.pop());
			}
		}
		if (!ops.empty()) {
			Stack<Character> temp1 = new Stack<Character>();
			Stack<Integer> temp2 = new Stack<Integer>();
			while (!ops.empty()) {
				temp1.push(ops.pop());
				temp2.push(nums.pop());
			}
			temp2.push(nums.pop());
			while (!temp1.empty()) {
				char op = temp1.pop();
				if (op == '+') {
					temp2.push(temp2.pop() + temp2.pop());
				} else if (op == '-') {
					temp2.push(temp2.pop() - temp2.pop());
				}
			}
			nums.push(temp2.pop());
		}
		return nums.pop();
	}
	/**
	 * 思路：无非都是加加减减，只要找到正确的符号就行了
	 * 遇到+，符号不变
	 * 遇到-，符号反转
	 * 遇到左括号，直到遇到右括号之前所有的数都受之前符号影响
	 * 遇到右括号，去除原来的符号的影响
	 */
	public int calculate1(String s) {
		Stack<Integer> stack=new Stack<Integer>();
		stack.push(1);
		stack.push(1);
		int res=0;
		for (int i = 0; i < s.length(); i++) {
			if(Character.isDigit(s.charAt(i))){
				String num="";
				while(i<s.length() && Character.isDigit(s.charAt(i))){
					num+=s.charAt(i);
					i++;
				}
				res+=Integer.parseInt(num)*stack.pop();
				i--;
			}else if(s.charAt(i)=='(' || s.charAt(i)=='+'){
				stack.push(stack.peek());
			}else if(s.charAt(i)=='-'){
				stack.push(stack.peek()*(-1));
			}else if(s.charAt(i)==')'){
				stack.pop();
			}
		}
		return res;
	}
	public static void main(String[] args) {
		System.out.println(new BasicCalculator().calculate1("1-(1+2)"));
	}
}
