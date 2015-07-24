package medium;

import java.util.HashMap;
import java.util.Map;

import util.TreeNode;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (inorder == null || inorder.length == 0) {
			return null;
		}
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
	}
	public TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd,
			Map<Integer, Integer> map) {
		if (preStart > preEnd || inStart > inEnd) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[preStart]);
		int index = map.get(root.val);
		root.left = helper(preorder, preStart + 1, preStart + index - inStart, inorder, inStart, index - 1, map);
		root.right = helper(preorder, preStart + index - inStart + 1, preEnd, inorder, index + 1, inEnd, map);
		return root;
	}
}
