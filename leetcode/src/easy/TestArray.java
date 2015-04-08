package easy;

public class TestArray {
	public static void main(String[] args) {
		long init=System.currentTimeMillis();
		System.out.println(new IndexOfSubString().indexOfKMP("mississippi","issi"));
		long now=System.currentTimeMillis();
		System.out.println(now-init);
		System.out.println(new IndexOfSubString().strStr("mississippi","issi"));
		System.out.println(System.currentTimeMillis()-now);
	}
	public static String generateString(int N){
		StringBuilder sb=new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(i*32424%256);
		}
		return sb.toString();
	}
}
