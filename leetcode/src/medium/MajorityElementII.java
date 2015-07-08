package medium;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {
	/**
	 * Moore投票算法
	 * 关键点：一个候选人在被替换时，其在重新开始算后中已不足三分之一
	 * 每次替换时，候选人1，候选人2,其余人 刚好组成三三分成
	 * 每次消去nums[i],num1,num2
	 * 
	 * 注意点：cnt表示的当前候选人多于之前三分之一的数值
	 * 统计时，注意初始值，去重。
	 */
    public List<Integer> majorityElement(int[] nums) {
    	List<Integer> res=new ArrayList<Integer>();
    	int num1=0;
    	int num2=0;
    	int cnt1=0;
    	int cnt2=0;
    	for (int i = 0; i < nums.length; i++) {
			if(nums[i]==num1){
				cnt1++;
			}else if(nums[i]==num2){
				cnt2++;
			}else if(cnt1==0){
				num1=nums[i];
				cnt1=1;
			}else if(cnt2==0){
				num2=nums[i];
				cnt2=1;
			}else{
				cnt1--;
				cnt2--;
			}
		}
    	cnt1=0;
    	cnt2=0;
    	for (int i = 0; i < nums.length; i++) {
			if(nums[i]==num1){
				cnt1++;
			}else if(nums[i]==num2){
				cnt2++;
			}
		}
    	if(cnt1>nums.length/3){
    		res.add(num1);
    	}
    	if(cnt2>nums.length/3){
    		res.add(num2);
    	}
    	return res;
    }
    public static void main(String[] args) {
		int[] nums={1,1,2,2,3};
		System.out.println(new MajorityElementII().majorityElement(nums));
	}
}
