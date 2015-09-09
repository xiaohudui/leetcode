package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GrayCode {
    public List<Integer> grayCode(int n) {
    	List<Integer> res=new ArrayList<Integer>();
    	if(n==0){
    		return res;
    	}
    	Stack<Integer> s1=new Stack<Integer>();
    	Stack<Integer> s2=new Stack<Integer>();
    	boolean flag=true;
    	s1.push(0);
    	s1.push(1);
    	res.add(0);
    	res.add(1);
    	for (int i = 1; i < n; i++) {
			int base=1<<i;
			int tail;
			if(flag){
				s2.addAll(s1);
				while(!s1.empty()){
					tail=s1.pop();
					res.add(base+tail);
					s2.push(base+tail);
				}
			}else{
				s1.addAll(s2);
				while(!s2.empty()){
					tail=s2.pop();
					res.add(base+tail);
					s1.push(base+tail);
				}
			}
			flag=!flag;
		}
    	return res;
    }
    public static void main(String[] args) {
		System.out.println(new GrayCode().grayCode(3));
	}
}
