package medium;
/**
 * 考虑细节，争取一次过
 * @author xiaohu
 *
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
			if(nums[i]==0){
				int j=i;
				while(true){
					if(j<0){
						return false;
					}
					if(j==nums.length-1){
						return true;
					}
					if(nums[j]>i-j){
						break;
					}
					j--;
				}
			}
		}
        return true;
    }
    public static void main(String[] args) {
		int[] nums={1,0,1};
		System.out.println(new JumpGame().canJump(nums));
	}
}
