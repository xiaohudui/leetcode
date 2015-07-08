package medium;

import java.util.Stack;

public class ImplementQueueUsingStacks {
	public static void main(String[] args) {
		MyQueue queue=new MyQueue();
		queue.push(1);
		queue.push(2);
		System.out.println(queue.peek());
		queue.pop();
		System.out.println(queue.peek());
	}
}
class MyQueue {
	Stack<Integer> stack=new Stack<Integer>();
	Stack<Integer> temp=new Stack<Integer>();
    // Push element x to the back of queue.
    public void push(int x) {
    	int n=stack.size();
        for (int i=0;i<n;i++) {
			temp.push(stack.pop());
		}
        temp.push(x);
        for (int i = 0; i < n+1; i++) {
			stack.push(temp.pop());
		}
    }

    // Removes the element from in front of queue.
    public void pop() {
        stack.pop();
    }

    // Get the front element.
    public int peek() {
        return stack.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack.empty();
    }
}