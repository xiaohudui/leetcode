package medium;

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
    	if(matrix==null || matrix.length==0){
    		return 0;
    	}
    	int res=0;
    	int[][] max=new int[matrix.length][matrix[0].length];
    	for (int i = 0; i < max.length; i++) {
			max[i][0]=matrix[i][0]-'0';
			res=res>max[i][0]?res:max[i][0];
		}
    	for (int i = 1; i < max[0].length; i++) {
			max[0][i]=matrix[0][i]-'0';
			res=res>max[0][i]?res:max[0][i];
		}
    	for (int i = 1; i < max.length; i++) {
			for (int j = 1; j < max[0].length; j++) {
				if(matrix[i][j]=='1'){
					max[i][j]=Math.min(Math.min(max[i-1][j], max[i][j-1]), max[i-1][j-1])+1;
				}
				res=res>max[i][j]?res:max[i][j];
			}
		}
    	return res*res;
    }
}
