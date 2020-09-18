package BinaryTree;
/** 
 * 二叉树的镜像
 * 
 * @ClassName MirrorTree 
 * @Description 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * @author guotg
 * @date 2020-9-16 16:49:53 
 *  
 */
class MirrorTree {
    public TreeNode mirrorTree(TreeNode root) {
    	TreeNode node = null;
    	if(root!=null) {
    		node = new TreeNode(root.val);
    		node.left = mirrorTree(root.left);
    		node.right = mirrorTree(root.right);
    	}
		return node;
    }
}