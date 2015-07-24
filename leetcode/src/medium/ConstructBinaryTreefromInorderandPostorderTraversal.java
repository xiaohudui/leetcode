package medium;

import java.util.HashMap;
import java.util.Map;

import util.TreeNode;

public class ConstructBinaryTreefromInorderandPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    	if(inorder==null || inorder.length==0){
    		return null;
    	}
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
        return helper(inorder,0,inorder.length-1,postorder,0,postorder.length-1,map);
    }
    public TreeNode helper(int[] inorder,int inStart,int inEnd,int[] postorder,int postStart,int postEnd,Map<Integer,Integer> map){
    	if(inStart>inEnd || postStart>postEnd){
    		return null;
    	}
    	TreeNode root=new TreeNode(postorder[postEnd]);
    	int index=map.get(root.val);
    	root.left=helper(inorder,inStart,index-1,postorder,postStart,postStart+index-inStart-1,map);
    	root.right=helper(inorder,index+1,inEnd,postorder,postStart+index-inStart,postEnd-1,map);
    	return root;
    }
}
