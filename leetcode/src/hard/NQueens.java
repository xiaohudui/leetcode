package hard;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
    	List<List<String>> res=new ArrayList<List<String>>();
    	helper(new int[n],0,res);
    	return res;
    }
    
    public void helper(int[] queens,int row,List<List<String>> res){
    	if(row==queens.length){
    		List<String> list=new ArrayList<String>();
    		StringBuilder sb=new StringBuilder();
    		for (int i = 0; i < queens.length; i++) {
				for (int j = 0; j < queens.length; j++) {
					if(j==queens[i]){
						sb.append('Q');
					}else{
						sb.append('.');
					}
				}
				list.add(sb.toString());
				sb.setLength(0);
			}
    		res.add(list);
    		return;
    	}
    	for (int i = 0; i < queens.length; i++) {
			if(canPlace(queens,row,i)){
				queens[row]=i;
				helper(queens,row+1,res);
			}
		}
    }
    
    public boolean canPlace(int[] queens,int x,int y){
    	for (int i = 0; i < x; i++) {
			if(queens[i]==y || Math.abs(i-x)==Math.abs(queens[i]-y)){
				return false;
			}
		}
    	return true;
    }
}
