package medium;

public class ContainerWithMostWater {
	/**
	 * 求最大值最小值：设定初始值，只有当可能变得更大或更小时才更新
	 * @param height
	 * @return
	 */
    public int maxArea(int[] height) {
    	if(height==null || height.length==1){
    		return 0;
    	}
    	int left=0;
    	int right=height.length-1;
        int max=Math.min(height[0], height[height.length-1])*(height.length-1);
        while(left<right){
        	if(height[left]<height[right]){
        		left++;
        	}else{
        		right--;
        	}
        	max=Math.max(max, Math.min(height[left], height[right])*(right-left));
        }
        return max;
    }
}
