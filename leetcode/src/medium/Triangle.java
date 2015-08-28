package medium;

import java.util.List;

public class Triangle {
	/**
	 * 方法一：递归遍历所有路径：超时
	 */
	public int minimumTotal1(List<List<Integer>> triangle) {
		if(triangle==null || triangle.size()==0){
			return 0;
		}
		long[] minSum=new long[1];
		minSum[0]=Long.MAX_VALUE;
		helper(triangle,1,0,minSum,triangle.get(0).get(0));
		return (int)minSum[0];
	}
	public void helper(List<List<Integer>> triangle, int depth, int index, long[] minSum, long sum) {
		if (depth == triangle.size()) {
			minSum[0] = minSum[0] < sum ? minSum[0] : sum;
			return;
		}
		helper(triangle,depth+1,index,minSum,sum+triangle.get(depth).get(index));
		helper(triangle,depth+1,index+1,minSum,sum+triangle.get(depth).get(index+1));
	}
	/**
	 * 动态规划，去除冗余的判断
	 * 思路：从底层开始，算出每个点到底部的最小，一直到顶点
	 */
	public int minimumTotal(List<List<Integer>> triangle) {
		if(triangle==null || triangle.size()==0){
			return 0;
		}
		long[] res=new long[triangle.size()];
		for (int i = 0; i < triangle.size(); i++) {
			res[i]=triangle.get(triangle.size()-1).get(i);
		}
		for (int i = triangle.size()-2; i >=0; i--) {
			for (int j = 0; j <= i; j++) {
				res[j]=Math.min(res[j], res[j+1])+triangle.get(i).get(j);
			}
		}
		return (int)res[0];
	}
}
