package easy;
import java.util.Stack;

public class ValidParentheses {
	/**
	 * 思路：若是左括号进栈，右括号若栈非空，且括号对应出栈，否则返回false
	 * 最后栈空返回true，否则为false
	 * @param s
	 * @return
	 */
	public boolean isValid(String s) {
		Stack<Character> stack=new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{'){
				stack.push(s.charAt(i));
			}else{
				if(!stack.isEmpty() &&(s.charAt(i)-stack.peek()==1||s.charAt(i)-stack.peek()==2)){
					stack.pop();
				}else{
					return false;
				}
			}
		}
		return stack.isEmpty();
	}
	public static void main(String[] args) {
		System.out.println(new ValidParentheses().isValid("()[]{}"));
	}
}
