package demo;

public class Demo {
	public static void main(String[] args) {
		int[] cnt=new int[1];
		System.out.println(cnt[0]);
		add(cnt);
		System.out.println(cnt[0]);
	}
	public static void add(int[] cnt){
		cnt[0]++;
	}
}
