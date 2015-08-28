package easy;

import java.util.ArrayList;
import java.util.List;

import util.TreeNode;

public class BinaryTreePaths {
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> res=new ArrayList<String>();
		if(root==null){
			return res;
		}
		helper(res,"",root);
		return res;
	}
	public void helper(List<String> res,String temp,TreeNode root){
		temp+=root.val+"->";
		if(root.left==null && root.right==null){
			temp=temp.substring(0,temp.length()-2);
			res.add(temp);
			return;
		}
		if(root.left!=null){
			helper(res,temp,root.left);
		}
		if(root.right!=null){
			helper(res,temp,root.right);
		}
	}
}
