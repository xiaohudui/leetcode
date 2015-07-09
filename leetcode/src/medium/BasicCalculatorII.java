package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class BasicCalculatorII {
	/**
	 * 中缀表达式转换为后缀表达式
	 * 1+2
	 * 1,2,+
	 */
    public int calculate(String s) {
    	Map<Character,Integer> priority=new HashMap<Character,Integer>();
    	init(priority);
    	List<String> list=new ArrayList<String>();
    	Stack<Character> stack=new Stack<Character>();
    	for (int i = 0; i < s.length(); i++) {
			if(Character.isDigit(s.charAt(i))){
				String num="";
				while(i<s.length() && Character.isDigit(s.charAt(i))){
					num+=s.charAt(i);
					i++;
				}
				list.add(num);
				i--;
			}else if(isOperator(s.charAt(i))){
				while(!stack.empty() && priority.get(stack.peek())>=priority.get(s.charAt(i))){
					list.add(stack.pop()+"");
				}
				stack.push(s.charAt(i));
			}else if(s.charAt(i)=='('){
				stack.push(s.charAt(i));
			}else if(s.charAt(i)==')'){
				while(!stack.empty() && stack.peek()!='('){
					list.add(stack.pop()+"");
				}
				stack.pop();
			}
		}
    	while(!stack.empty()){
    		list.add(stack.pop()+"");
    	}
    	Stack<Long> operands=new Stack<Long>();
    	for (int i = 0; i < list.size(); i++) {
    		if(isOperator(list.get(i).charAt(0))){
    			long operand1=operands.pop();
    			long operand2=operands.pop();
    			switch(list.get(i).charAt(0)){
    				case '+':operands.push(operand2+operand1);break;
    				case '-':operands.push(operand2-operand1);break;
    				case '*':operands.push(operand2*operand1);break;
    				case '/':operands.push(operand2/operand1);break;
    				default:break;
    			}
    		}else{
    			operands.add(Long.parseLong(list.get(i)));
    		}
		}
    	long res=operands.pop();
    	return (int)res;
    }
    public void init(Map<Character,Integer> priority){
    	priority.put('+', 1);
    	priority.put('-', 1);
    	priority.put('*', 2);
    	priority.put('/', 2);
    	priority.put('(', 0);
    }
    public boolean isOperator(char ch){
    	char[] operators={'+','-','*','/'};
    	for (int i = 0; i < operators.length; i++) {
			if(ch==operators[i]){
				return true;
			}
		}
    	return false;
    }
    public static void main(String[] args) {
		System.out.println(new BasicCalculatorII().calculate("0-2147483648"));
	}
}
