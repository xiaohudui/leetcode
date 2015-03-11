public class ZigZag {
	public static String convert(String s, int nRows) {
		if (s.length() == 0) {
			return "";
		}
		if (nRows == 1) {
			return s;
		}
		int size = 2 * nRows - 2;
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < nRows; i++) {
			for (int j = i; j < s.length(); j += size) {
				res.append(s.charAt(j));
				if (i != 0 && i != nRows - 1 && j + size - 2 * i < s.length()) {
					res.append(s.charAt(j + size - 2 * i));
				}
			}
		}
		return res.toString();
	}
	public static void main(String[] args) {
		String s = "PAYPALISHIRING";
		if(convert(s, 3).equals("PAHNAPLSIIGYIR")){
			System.out.println("success");
		}else{
			System.out.println("fail");
		}
	}
}
