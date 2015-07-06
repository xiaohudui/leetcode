package easy;

public class RectangleArea {
	/**
	 * 陷阱：溢出错误
	 * 类型扩展：用更大的数据类型防止溢出
	 */
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        long sum=(C-A)*(D-B)+(G-E)*(H-F);
        long intersect=Math.max(Math.min((long)G, C)-Math.max((long)A, E), 0)*
        		Math.max(Math.min((long)D, H)-Math.max((long)B, F), 0);
        return (int)(sum-intersect);
    }
    
    public static void main(String[] args) {
		System.out.println(new RectangleArea().computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
	}
}
