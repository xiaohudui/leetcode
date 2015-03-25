package easy;
import java.util.ArrayList;
import java.util.List;
/**
 * 思路一：使用迭代的方法，存储前一行的结果，会造成空间的浪费，数据量大时会不断GC
 * 思路二：只是用一行来存储，每次从后向前算，就不会覆盖之前的结果
 * @author xiaohu
 *
 */
public class PascalTriangleII {
	public List<Integer> getRow(int rowIndex) {
		List<Integer> prev=new ArrayList<Integer>();
		List<Integer> last=new ArrayList<Integer>();
		prev.add(1);
		for (int i = 0; i < rowIndex; i++) {
			last.add(1);
			for (int j = 0; j < prev.size()-1; j++) {
				last.add(prev.get(j)+prev.get(j+1));
			}
			last.add(1);
			prev=last;
			last=new ArrayList<Integer>();
		}
		return prev;
	}
	public List<Integer> getRow1(int rowIndex){
		List<Integer> res=new ArrayList<Integer>();
		res.add(1);
		for (int i = 0; i < rowIndex; i++) {
			for (int j = res.size()-1; j >0; j--) {
				res.set(j, res.get(j)+res.get(j-1));
			}
			res.add(1);
		}
		return res;
	}
	public static void main(String[] args) {
		
	}
}
