package medium;

/**
 * 关键点：
 * 1. 找到坐标转换公式
 * 2. 找到不重不漏的四分之一，使得只转换一次
 */
public class RotateImage {
	/**
	 * 思路一：用数组标记是否已访问过
	 * @param matrix
	 */
    public void rotate(int[][] matrix) {
    	if(matrix==null || matrix.length==0){
    		return;
    	}
    	int n=matrix.length;
    	boolean[][] visited=new boolean[n][n];
    	int[] rotate=new int[5];
    	for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(!visited[i][j]){
					int x=i;
					int y=j;
					rotate[0]=matrix[x][y];
					for (int k = 0; k < 4; k++) {
						visited[x][y]=true;
						int temp=x;
						x=y;
						y=n-1-temp;
						rotate[k+1]=matrix[x][y];
						matrix[x][y]=rotate[k];
					}
				}
			}
		}
    }
    /**
     * 不重不漏的四分之一：0<i<n/2	i<=j<n-1-i	取一条边界线
     * 实心部分	
     * *************
     * 	* *	*  *  *	*
     * 	*  * *	*	*
     * 	*	 *		*
     * 	*			*
     * 	*			*
     * 	*************
     */
    public void rotate1(int[][] matrix) {
    	int n=matrix.length;
    	for (int i = 0; i < n/2; i++) {
			for (int j = i; j < n-1-i; j++) {
				int temp=matrix[i][j];
				matrix[i][j]=matrix[n-1-j][i];
				matrix[n-1-j][i]=matrix[n-1-i][n-1-j];
				matrix[n-1-i][n-1-j]=matrix[j][n-1-i];
				matrix[j][n-1-i]=temp;
			}
		}
    }
}
