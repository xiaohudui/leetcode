package medium;

import java.util.ArrayList;
import java.util.List;

public class CourseScheduleII {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] res = new int[numCourses];
		int[] degrees = new int[numCourses];
		List<ArrayList<Integer>> parents = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < numCourses; i++) {
			parents.add(new ArrayList<Integer>());
		}
		for (int[] pair : prerequisites) {
			degrees[pair[0]]++;
			parents.get(pair[1]).add(pair[0]);
		}
		boolean flag = true;
		int cnt = 0;
		while (flag) {
			flag = false;
			for (int i = 0; i < numCourses; i++) {
				if (degrees[i] == 0) {
					res[cnt++] = i;
					degrees[i]--;
					for (int parent : parents.get(i)) {
						degrees[parent]--;
						flag = true;
					}
				}
			}
		}
		if (cnt < numCourses) {
			return new int[]{};
		} else {
			return res;
		}
	}
}
