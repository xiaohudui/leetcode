package easy;
/**
 * 动态规划，利用前面判断的结果推到下一次
 * @author xiaohu
 *
 */
public class HouseRobber {
    public int rob(int[] num) {
    	int N=num.length;
    	if(N==0){
    		return 0;
    	}
    	if(N==1){
    		return num[0];
    	}
    	int prev=num[0]>num[1]?num[0]:num[1];
    	int pprev=num[0];
    	int maxN=prev>pprev?prev:pprev;
    	for (int i = 2; i < N; i++) {
    		maxN=prev>(pprev+num[i])?prev:(pprev+num[i]);
    		pprev=prev;
    		prev=maxN;
		}
    	return maxN;
    }
}
