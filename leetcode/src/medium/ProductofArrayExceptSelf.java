package medium;

import java.util.Arrays;

public class ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
    	int n=nums.length;
    	int[] dp1=new int[n];
    	dp1[0]=1;
    	int[] dp2=new int[n];
    	dp2[n-1]=1;
    	for (int i = 1; i < n; i++) {
			dp1[i]=dp1[i-1]*nums[i-1];
			dp2[n-i-1]=dp2[n-i]*nums[n-i];
		}
    	int[] output=new int[n];
    	for (int i = 0; i < n; i++) {
			output[i]=dp1[i]*dp2[i];
		}
    	return output;
    }
    public static void main(String[] args) {
    	int[] nums={1,2,3,4};
		System.out.println(Arrays.toString(new ProductofArrayExceptSelf().productExceptSelf(nums)));
	}
}
