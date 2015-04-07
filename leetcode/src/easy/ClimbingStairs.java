package easy;

public class ClimbingStairs {
	public int climbStairs(int n) {
		int pprev = 1;
		int prev = 2;
		int cur=0;
		if (n <= 2) {
			return n;
		}
		for (int i = 2; i < n; i++) {
			cur=pprev+prev;
			pprev=prev;
			prev=cur;
		}
		return cur;
	}
}
