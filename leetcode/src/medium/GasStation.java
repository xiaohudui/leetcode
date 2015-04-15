package medium;

public class GasStation {
	/**
	 * 改进思路：两条原则 1. 如果从0到i可以，i到i+1卡住了，那么0-i之间的就不用再尝试了 2.
	 * 如果i点能走到i+k点，那么（i+1到i+k）中的任一点能成功的话i点一定能成功 3.
	 * 如果总油量大于等于总消耗的话就一定能成功，否则一定不能成功（需要证明）
	 * 证明：1+2+3+...+n>=0
	 * 必然存在 i+(i+1)+...+n>=前面加不下去的负值点的负值
	 * 故存在i使一直为正
	 */
	public int canCompleteCircuit1(int[] gas, int[] cost) {
		int total = 0, curSum = 0;
		int n = gas.length;
		int res = 0;
		for (int i = 0; i < n; i++) {
			total += gas[i] - cost[i];
			curSum += gas[i] - cost[i];
			if (curSum < 0) {
				curSum = 0;
				res = i + 1;
			}
		}
		return total >= 0 ? res : -1;
	}
	/**
	 * 思路：如果从0到i可以，i到i+1卡住了，那么0-i之间的就不用再尝试了 时间复杂度n,最坏跑两遍
	 */
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int mass = 0;
		int n = gas.length;
		int i = 0;
		int cnt = 0;
		for (int k = 0; k < n; k++) {
			mass = gas[i % n];
			while (cnt < n) {
				if (mass >= cost[i % n]) {
					mass += gas[(i + 1) % n] - cost[i % n];
					cnt++;
					i++;
				} else {
					break;
				}
			}
			if (cnt == n) {
				return i - n;
			} else {
				i++;
				cnt = 0;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		int[] A = {1,5,1,5};
		int[] B = {2,5,1,1};
		System.out.println(new GasStation().canCompleteCircuit1(A, B));
	}
}
