package medium;

import java.util.Arrays;

public class Searcha2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
    	if(matrix==null || matrix.length==0){
    		return false;
    	}
    	int m=matrix.length;
    	int n=matrix[0].length;
    	for (int i = 0; i < m; i++) {
			if(target>=matrix[i][0] && target<=matrix[i][n-1] && Arrays.binarySearch(matrix[i], target)>=0){
				return true;
			}
		}
    	return false;
    }
    public boolean searchMatrix1(int[][] matrix, int target) {
    	if(matrix==null || matrix.length==0){
    		return false;
    	}
    	int m=matrix.length;
    	int n=matrix[0].length;
    	int i=m-1;
    	int j=0;
    	while(true){
    		if(i<0 || j>n-1){
    			return false;
    		}
    		if(matrix[i][j]>target){
    			i--;
    		}else if(matrix[i][j]<target){
    			j++;
    		}else{
    			return true;
    		}
    	}
    }
}
