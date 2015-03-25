package easy;
import java.util.Arrays;

public class CompareVersionNumbers {
	public int compareVersion(String version1, String version2) {
		String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");
		for (int i = 0; i < v2.length && i < v1.length; i++) {
			int value1 = Integer.parseInt(v1[i]);
			int value2 = Integer.parseInt(v2[i]);
			if (value1 > value2) {
				return 1;
			} else if (value1 < value2) {
				return -1;
			}
		}
		if (v1.length > v2.length) {
			int i = v2.length;
			while (i < v1.length && Integer.parseInt(v1[i]) == 0) {
				i++;
			}
			if (i == v1.length) {
				return 0;
			} else {
				return 1;
			}
		} else if (v1.length < v2.length) {
			int i = v1.length;
			while (i < v2.length && Integer.parseInt(v2[i]) == 0) {
				i++;
			}
			if (i == v2.length) {
				return 0;
			} else {
				return -1;
			}
		}
		return 0;
	}
	public static void main(String[] args) {
		System.out.println(Arrays.toString("1.2.3.4".split("\\.")));
	}
}
