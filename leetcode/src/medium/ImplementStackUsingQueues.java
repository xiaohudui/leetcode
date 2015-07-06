package medium;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {
}
/**
 * 循环移位将开始元素移动到结尾，不改变原先顺序
 * 对比反转
 * @author xiaohu
 *
 */
class MyStack {
	Queue<Integer> queue;
	public MyStack() {
		queue = new LinkedList<Integer>();
	}
	// Push element x onto stack.
	public void push(int x) {
		queue.offer(x);
		for (int i = 0; i < queue.size() - 1; i++) {
			queue.offer(queue.poll());
		}
	}

	// Removes the element on top of the stack.
	public void pop() {
		queue.poll();
	}

	// Get the top element.
	public int top() {
		return queue.peek();
	}

	// Return whether the stack is empty.
	public boolean empty() {
		return queue.isEmpty();
	}
}
