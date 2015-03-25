package easy;
import java.util.Stack;

public class ValidParentheses {
	/**
	 * ˼·�����������Ž�ջ����������ջ�ǿգ������Ŷ�Ӧ��ջ�����򷵻�false
	 * ���ջ�շ���true������Ϊfalse
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
