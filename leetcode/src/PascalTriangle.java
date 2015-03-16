import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
	/**
	 * for循环看上去更紧凑，边界条件初始不考虑，最后用边界来实例化讨论
	 * @param numRows
	 * @return
	 */
	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (numRows == 0) {
			return res;
		}
		List<Integer> prev = new ArrayList<Integer>();
		prev.add(1);
		res.add(prev);
		List<Integer> last = new ArrayList<Integer>();
		for(int i=2;i<=numRows;i++){
			last.add(1);
			for (int j = 2; j < i; j++) {
				last.add(prev.get(j-2)+prev.get(j-1));
			}
			last.add(1);
			res.add(last);
			prev = last;
			last = new ArrayList<Integer>();
		}
		return res;
	}
	public static void main(String[] args) {
		System.out.println(generate(6));
	}
}
