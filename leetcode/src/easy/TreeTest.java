package easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeTest {
	public static void main(String[] args) {
		int[] values={1,0,2,0,0,0,3};
		TreeNode root = construct(values);
		System.out.println(new BalancedBinaryTree().isBalanced(root));
		printTree(root);
	}
	public static TreeNode construct(int[] values){
		int N=values.length;
		if(N==0){
			return null;
		}
		List<TreeNode> list=new ArrayList<TreeNode>();
		for (int i = 0; i < N; i++) {
			list.add(new TreeNode(values[i]));
		}
		for (int i = 0; i < N/2; i++) {
			if(2*i+1<N && list.get(2*i+1).val!=0){
				list.get(i).left=list.get(2*i+1);
			}
			if(2*i+2<N && list.get(2*i+2).val!=0){
				list.get(i).right=list.get(2*i+2);
			}
		}
		return list.get(0);
	}
	public static void printTree(TreeNode root){
		Queue<TreeNode> queue=new LinkedList<TreeNode>();
		int lastNum=1,curNum=0;
		queue.offer(root);
		while(!queue.isEmpty()){
			TreeNode node=queue.poll();
			System.out.print(node.val+"    ");
			lastNum--;
			if(node.left!=null){
				queue.offer(node.left);
				curNum++;
			}
			if(node.right!=null){
				queue.offer(node.right);
				curNum++;
			}
			if(lastNum==0){
				System.out.println();
				lastNum=curNum;
				curNum=0;
			}
		}
	}
}
