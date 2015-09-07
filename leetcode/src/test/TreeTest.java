package test;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import medium.UniqueBinarySearchTreeII;
import util.TreeNode;

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
		printTree(t1);
		List<TreeNode> res=new UniqueBinarySearchTreeII().generateTrees(3);
		for (TreeNode root : res) {
			printTree(root);
		}
	}
	public static void printTree(TreeNode root){
		if(root==null){
			return;
		}
		boolean lastLevel=false;
		Queue<TreeNode> queue=new LinkedList<TreeNode>();
		queue.offer(root);
		String res="";
		while(!queue.isEmpty() && !lastLevel){
			TreeNode node=queue.poll();
			if(node==null){
				res+="# ";
				continue;
			}else{
				res+=node.val+" ";
				queue.offer(node.left);
				queue.offer(node.right);
			}
		}
		int index=res.length()-1;
		while(index>0 && (res.charAt(index)==' ' || res.charAt(index)=='#')){
			index--;
		}
		System.out.println(res.substring(0,index+1));
	}
}
