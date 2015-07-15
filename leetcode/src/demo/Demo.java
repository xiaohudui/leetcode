package demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Demo {
	public static void main(String[] args) {
		Set<List<Integer>> set=new HashSet<List<Integer>>();
		List<Integer> list1=new ArrayList<Integer>();
		list1.add(1);
		List<Integer> list2=new ArrayList<Integer>();
		list2.add(1);
		set.add(list1);
		set.add(list2);
	}
	public static void add(int[] cnt){
		cnt[0]++;
	}
}
