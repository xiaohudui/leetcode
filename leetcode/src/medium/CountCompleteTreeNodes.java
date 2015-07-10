package medium;

import util.TreeNode;

public class CountCompleteTreeNodes {
	/**
	 * 关键点：二分法查找最后一行个数
	 * 最后一个节点编号：左 编0，右编1，判断该节点是否存在
	 * 
	 * 注意点：二分法中必须注意：
	 * 1. high>=low 还是high>low
	 * 2. 返回的到底是high 还是low
	 * @param root
	 * @return
	 */
    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
    	TreeNode node=root;
    	int h=0;
    	while(node!=null){
    		node=node.left;
    		h++;
    	}
    	int low=0;
    	int high=(1<<h-1)-1;
    	while(high>=low){
    		int mid=(high+low)/2;
    		if(exist(root,h,mid)){
    			low=mid+1;
    		}else{
    			high=mid-1;
    		}
    	}
    	return high+(1<<h-1);
    }
    public boolean exist(TreeNode root,int h,int num){
    	TreeNode node=root;
    	for (int i = 0; i < h-1; i++) {
			if(((num>>(h-i-2))&1)==1){
				node=node.right;
			}else{
				node=node.left;
			}
		}
    	return node!=null;
    }
}
