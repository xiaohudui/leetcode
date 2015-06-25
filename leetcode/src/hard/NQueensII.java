package hard;

public class NQueensII {
    public int totalNQueens(int n) {
        int[] queens=new int[n];
        int[] cnt=new int[1];
        helper(queens,0,cnt);
        return cnt[0];
    }
    
    public void helper(int[] queens,int row,int[] cnt){
    	if(row==queens.length){
    		cnt[0]++;
    		return;
    	}
    	for (int i = 0; i < queens.length; i++) {
			if(canPlace(queens,row,i)){
				queens[row]=i;
				helper(queens,row+1,cnt);
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
    public static void main(String[] args) {
		System.out.println(new NQueensII().totalNQueens(8));
	}
}
