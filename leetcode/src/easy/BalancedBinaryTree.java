package easy;
/**
 * 思路一：（递归）如果左子树与右子树的高度相差超过一，false，否则true
 * 
 * @author xiaohu
 *
 */
public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		if (getHeight(root) == -1) {
			return false;
		}
		return true;
	}
	public int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = getHeight(root.left);
		int right = getHeight(root.right);
		if (left == -1 || right == -1) {
			return -1;
		}
		if (Math.abs(left - right) > 1) {
			return -1;
		}
		return Math.max(left+1, right+1);
	}
}