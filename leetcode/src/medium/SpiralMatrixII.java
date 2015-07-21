package medium;

import java.util.Arrays;

public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] res=new int[n][n];
        int cycle=n/2;
        int cnt=1;
        for (int i = 0; i <= cycle; i++,n-=2) {
			for (int j = i; j < i+n; j++) {
				res[i][j]=cnt++;
			}
			for (int j = i+1; j < i+n; j++) {
				res[j][i+n-1]=cnt++;
			}
			if(n==1){
				return res;
			}
			for (int j = i+n-2; j >=i; j--) {
				res[i+n-1][j]=cnt++;
			}
			for (int j = i+n-2; j > i; j--) {
				res[j][i]=cnt++;
			}
		}
        return res;
    }
    public static void main(String[] args) {
		System.out.println(Arrays.deepToString(new SpiralMatrixII().generateMatrix(3)));
	}
}
