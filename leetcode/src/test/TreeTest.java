package test;
import java.util.LinkedList;
import java.util.Queue;

import medium.PathSumII;
import util.TreeNode;
import easy.BinaryTreePaths;
import easy.InvertBinaryTree;

@SuppressWarnings("all")
public class TreeTest {
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		t1.left = t2;
		t1.right = t3;
		t3.left = t4;
		t3.right = t5;
		System.out.println(new BinaryTreePaths().binaryTreePaths(t1));
	}
	public static void printTree(TreeNode root){
		if(root==null){
			return;
		}
		Queue<TreeNode> queue=new LinkedList<TreeNode>();
		TreeNode nullNode=new TreeNode(-1);
		int nullCnt=0;
		int i=0;
		int j=0;
		queue.offer(root);
		while(!queue.isEmpty()){
			TreeNode node=queue.poll();
		}
	}
}
