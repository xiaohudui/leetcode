package medium;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
	public List<String> restoreIpAddresses(String s) {
		List<String> res = new ArrayList<String>();
		if(s.length()<4 || s.length()>12){
			return res;
		}
		helper(s, "", res, 0);
		return res;
	}
	public void helper(String s, String temp, List<String> res, int cnt) {
		if (cnt == 3) {
			if (isValid(s)) {
				res.add(temp + s);
			}
			return;
		}
		for (int i = 1; i < 4 && i<s.length(); i++) {
			if (isValid(s.substring(0, i))) {
				helper(s.substring(i), temp+s.substring(0, i) + ".", res, cnt + 1);
			}
		}
	}
	public boolean isValid(String s) {
		if (s.startsWith("0")) {
			return s.equals("0");
		}
		return Integer.parseInt(s) <= 255 && Integer.parseInt(s) >= 0;
	}
	public static void main(String[] args) {
		System.out.println(new RestoreIPAddresses().restoreIpAddresses("25525511135"));
	}
}
