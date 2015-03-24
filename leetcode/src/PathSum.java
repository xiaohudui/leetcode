import java.util.Stack;

/**
 * 思路一:递归（前序遍历） 检查顺序：先左子树，再右子树，递归，所以总顺序就是叶子节点从左到右的顺序（每一个叶子节点对应唯一的路径） 思路二：非递归
 * 思路二：非递归，模拟递归的保留当前结果的算法，也需要栈空间
 * @author xiaohu
 *
 */
public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		if (root.left == null && root.right == null && sum == root.val) {
			return true;
		}
		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	}
	public boolean hasPathSum1(TreeNode root, int sum) {
		Stack<TreeNode> nodes = new Stack<TreeNode>();
		Stack<Integer> sums=new Stack<Integer>();
		if (root != null) {
			nodes.push(root);
			sums.push(root.val);
			while (!nodes.isEmpty()) {
				TreeNode node = nodes.pop();
				int sumValue=sums.pop();
				if(node.left==null && node.right==null && sum==sumValue){
					return true;
				}
				if(node.left!=null){
					nodes.push(node.left);
					sums.push(sumValue+node.left.val);
				}
				if(node.right!=null){
					nodes.push(node.right);
					sums.push(sumValue+node.right.val);
				}
			}
		}
		return false;
	}
}
