package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import util.TreeNode;

/**
 * 层序遍历，输出每一层的 最后一个
 * @author xiaohu
 *
 */
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res=new ArrayList<Integer>();
        if(root==null){
        	return res;
        }
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        int cnt=1;
        int cur=0;
        queue.offer(root);
        while(!queue.isEmpty()){
        	TreeNode node=queue.poll();
        	cnt--;
        	if(node.left!=null){
        		queue.offer(node.left);
        		cur++;
        	}
        	if(node.right!=null){
        		queue.offer(node.right);
        		cur++;
        	}
        	if(cnt==0){
        		cnt=cur;
        		cur=0;
        		res.add(node.val);
        	}
        }
        return res;
    }
}
