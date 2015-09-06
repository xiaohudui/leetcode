package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

import util.Interval;

public class MergeOverlapping {
	public List<Interval> merge(List<Interval> intervals) {
		Collections.sort(intervals, new IntervalComparator());
		Stack<Interval> stack = new Stack<Interval>();
		for (Interval interval : intervals) {
			if (stack.empty()) {
				stack.push(interval);
			} else {
				Interval temp1 = stack.pop();
				Interval temp2 = merge(temp1, interval);
				if (temp2 != null) {
					stack.push(temp2);
				} else {
					stack.push(temp1);
					stack.push(interval);
				}
			}
		}
		return new ArrayList<Interval>(stack);
	}

	public Interval merge(Interval i1, Interval i2) {
		Interval res = new Interval();
		if (i1.end >= i2.start) {
			res.start = i1.start;
			res.end = Math.max(i1.end, i2.end);
			return res;
		} else {
			return null;
		}
	}
	class IntervalComparator implements Comparator<Interval> {
		@Override
		public int compare(Interval o1, Interval o2) {
			return o1.start - o2.start;
		}
	}
	public static void main(String[] args) {
		List<Interval> intervals=new ArrayList<Interval>();
		intervals.add(new Interval(0,0));
		intervals.add(new Interval(1,3));
		System.out.println(new MergeOverlapping().merge(intervals));
	}
}
