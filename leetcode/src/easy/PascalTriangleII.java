package easy;
import java.util.ArrayList;
import java.util.List;
/**
 * ˼·һ��ʹ�õ����ķ������洢ǰһ�еĽ��������ɿռ���˷ѣ���������ʱ�᲻��GC
 * ˼·����ֻ����һ�����洢��ÿ�δӺ���ǰ�㣬�Ͳ��Ḳ��֮ǰ�Ľ��
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
