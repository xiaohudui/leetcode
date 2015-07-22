package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses {
	/**
	 * 利用之前的全排列
	 */
    public List<String> generateParenthesis(int n) {
    	List<String> res=new ArrayList<String>();
    	char[] elements=new char[n*2];
    	for (int i = 0; i < n; i++) {
			elements[i]='(';
			elements[n+i]=')';
		}
    	helper(res,elements,0);
    	return res;
    }
    public void helper(List<String> res,char[] elements,int start){
    	if(start==elements.length){
    		String str=new String(elements);
    		if(isValid(str)){
    			res.add(str);
    		}
    		return;
    	}
    	for (int i = start; i < elements.length; i++) {
    		if(!isDuplicate(elements, start, i)){
    			swap(elements,start,i);
    			helper(res,elements,start+1);
    			swap(elements,start,i);
    		}
		}
    }
    public void swap(char[] elements,int start,int end){
    	char temp=elements[start];
    	elements[start]=elements[end];
    	elements[end]=temp;
    }
    public boolean isDuplicate(char[] elements,int start,int end){
    	for (int i = start; i < end; i++) {
			if(elements[i]==elements[end]){
				return true;
			}
		}
    	return false;
    }
    public boolean isValid(String parenthesis){
    	Stack<Character> stack=new Stack<Character>();
    	for (int i = 0; i < parenthesis.length(); i++) {
			if(parenthesis.charAt(i)=='('){
				stack.push('(');
			}else{
				if(stack.empty()){
					return false;
				}else{
					stack.pop();
				}
			}
		}
    	return stack.empty();
    }
    /**
     * 利用递归思想
     * 只要之前左括号比右括号不少就行
     */
    public List<String> generateParenthesis1(int n) {
    	List<String> res=new ArrayList<String>();
    	helper1(res,n,n,new String());
    	return res;
    }
    public void helper1(List<String> res,int left,int right,String str){
    	if(left==0 && right==0){
    		res.add(str);
    		return;
    	}
    	if(left>right){
    		return;
    	}
    	if(left==0){
    		helper1(res,left,right-1,str+')');
    	}else{
    		helper1(res,left-1,right,str+'(');
    		helper1(res,left,right-1,str+')');
    	}
    }
    public static void main(String[] args) {
		System.out.println(new GenerateParentheses().generateParenthesis1(3));
	}
}
