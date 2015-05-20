package medium;

public class HouseRobberII {
    public int rob(int[] nums) {
    	if(nums==null || nums.length==0){
    		return 0;
    	}
    	if(nums.length==1){
    		return nums[0];
    	}
    	int pprev=nums[0];
    	int prev=Math.max(nums[0], nums[1]);
    	int maxN=Math.max(pprev, prev);
    	for (int i = 2; i < nums.length-1; i++) {
			maxN=Math.max(maxN, pprev+nums[i]);
			pprev=prev;
			prev=maxN;
		}
    	pprev=nums[1];
    	prev=Math.max(nums[1], nums[2]);
    	int max1=Math.max(prev, pprev);
    	for (int i = 3; i < nums.length; i++) {
			max1=Math.max(max1, pprev+nums[i]);
			pprev=prev;
			prev=max1;
		}
    	return Math.max(maxN, max1);
    }
}
