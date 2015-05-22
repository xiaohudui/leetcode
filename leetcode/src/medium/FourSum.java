package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
	/**
	 * 思路一：四次和转换为三次和，在转换为二次和
	 * 关键点：去重
	 * 策略：取重复值的第一个，将其余重复的值传下去，
	 * 下一次跳过所有的重复的，因为结果中包含多个相同值的情况已经包含了
	 * 
	 * 注意点：去除重复的只有当找到了，才去除重复的否则可能漏掉两个相同，单和为target的情况
	 * @param nums
	 * @param target
	 * @return
	 */
    public List<List<Integer>> fourSum(int[] nums, int target) {
    	List<List<Integer>> res=new ArrayList<List<Integer>>();
    	if(nums==null || nums.length<4){
    		return res;
    	}
    	Arrays.sort(nums);
    	for (int i = 0; i < nums.length-2; i++) {
			if(i>0 && nums[i]==nums[i-1]){
				continue;
			}
			int newTarget=target-nums[i];
			threeSum(nums,newTarget,res,i);
		}
    	return res;
    }
    public void threeSum(int[] nums,int target,List<List<Integer>> res,int start){
    	for (int i = start+1; i < nums.length-1; i++) {
			if(i>start+1 && nums[i]==nums[i-1]){
				continue;
			}
			int newTarget=target-nums[i];
			twoSum(nums,newTarget,res,start,i);
		}
    }
    public void twoSum(int[] nums,int target,List<List<Integer>> res,int i,int j){
    	int start=j+1;
    	int end=nums.length-1;
    	while(start<end){
    		if(nums[start]+nums[end]>target){
    			end--;
    		}else if(nums[start]+nums[end]<target){
    			start++;
    		}else{
    			List<Integer> list=new ArrayList<Integer>();
    			list.add(nums[i]);
    			list.add(nums[j]);
    			list.add(nums[start]);
    			list.add(nums[end]);
    			res.add(list);
    			while(start<end && nums[start]==nums[start+1]){
    				start++;
    			}
    			while(start<end && nums[end]==nums[end-1]){
    				end--;
    			}
    			end--;
    			start++;
    		}
    	}
    }
    /** 
     * 思路二：重新构造数据结构Four，重写hashCode，和equals 方法，利用set进行去重O(N^3)
     * 思路三：求出所有的两两和，然后再用twoSum求出所有的pPair，然后组合，需要较为复杂的去重
     * @param args
     */
    public static void main(String[] args) {
		int[] nums={-1,0,-5,-2,-2,-4,0,1,-2};
		System.out.println(new FourSum().fourSum(nums, -9));
	}
}
