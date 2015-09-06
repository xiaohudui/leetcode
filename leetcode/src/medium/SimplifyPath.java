package medium;

import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        String[] ss=path.split("/");
        Stack<String> stack=new Stack<String>();
        for (String s : ss) {
			if(s.equals("") || s.equals(".")){
				
			}else if(s.equals("..")){
				if(!stack.empty()){
					stack.pop();
				}
			}else{
				stack.push(s);
			}
		}
        if(stack.empty()){
        	return "/";
        }
        String res="";
        while(!stack.empty()){
        	res="/"+stack.pop()+res;
        }
        return res;
    }
    public static void main(String[] args) {
		System.out.println(new SimplifyPath().simplifyPath("/../"));
	}
}
