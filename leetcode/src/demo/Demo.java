package demo;

import java.util.ArrayList;
import java.util.List;

public class Demo {
	public static void main(String[] args) {
		List<Integer> list=new ArrayList<Integer>();
		list.add(0,1);
		list.add(1,0);
		list.remove(new Integer(1));
		System.out.println(list);
	}
	public static void add(int[] cnt){
		cnt[0]++;
	}
}
