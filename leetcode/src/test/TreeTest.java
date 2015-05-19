package test;

import medium.InOrder;
import util.TreeNode;

public class TreeTest {
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(10);
		TreeNode t2 = new TreeNode(5);
		TreeNode t3 = new TreeNode(15);
		TreeNode t4 = new TreeNode(6);
		TreeNode t5 = new TreeNode(20);
		t1.left = t2;
		t1.right = t3;
		t3.left = t4;
		t3.right = t5;
		InOrder it=new InOrder();
		System.out.println(it.traverse(t1));
	}
}
