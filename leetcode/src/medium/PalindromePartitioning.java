package medium;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
    	List<List<String>> res=new ArrayList<List<String>>();
    	boolean[][] dict=isPalin(s);
    	helper(s,0,new ArrayList<String>(),res,dict);
    	return res;
    }
    public void helper(String s,int start,List<String> items,List<List<String>> res,boolean[][] dict){
    	if(start==s.length()){
    		//注意不能直接用items，items会改变
    		res.add(new ArrayList<String>(items));
    		return;
    	}
    	for (int i = start; i < s.length(); i++) {
			if(dict[start][i]){
				items.add(s.substring(start,i+1));
    			helper(s,i+1,items,res,dict);
	    		items.remove(items.size()-1);
			}
		}
    }
    public boolean[][] isPalin(String s){
    	int len=s.length();
    	boolean[][] isPalin=new boolean[len][len];
    	//注意顺序，因为后面的要用到前面的，顺序不能错
    	for (int i = len-1; i >=0; i--) {
			for (int j = i; j < len; j++) {
				if(s.charAt(i)==s.charAt(j) && (j-i<2 || isPalin[i+1][j-1])){
					isPalin[i][j]=true;
				}
			}
		}
    	return isPalin;
    }
}
