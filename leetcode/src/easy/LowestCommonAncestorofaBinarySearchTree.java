package easy;

import java.util.ArrayList;
import java.util.List;

import util.TreeNode;

public class LowestCommonAncestorofaBinarySearchTree {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root==null){
			return root;
		}
		List<TreeNode> route1 = new ArrayList<TreeNode>();
		List<TreeNode> route2 = new ArrayList<TreeNode>();
		TreeNode node=root;
		while(true){
			route1.add(node);
			if(node.val>p.val){
				node=node.left;
			}else if(node.val<p.val){
				node=node.right;
			}else{
				break;
			}
		}
		node=root;
		while(true){
			route2.add(node);
			if(node.val>q.val){
				node=node.left;
			}else if(node.val<q.val){
				node=node.right;
			}else{
				break;
			}
		}
		int i=0;
		while(i < route1.size() && i< route2.size() && route1.get(i)==route2.get(i)) {
			i++;
		}
		return route1.get(i-1);
	}
}
