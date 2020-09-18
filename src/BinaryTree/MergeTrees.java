package BinaryTree;
/** 
 * 合并二叉树
 * 
 * @ClassName MergeTrees 
 * @Description 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 * @author guotg
 * @date 2020-9-16 16:58:29 
 *  
 */
class MergeTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    	if(t1 == null && t2 == null)return null;
    	TreeNode node = new TreeNode((t1==null?0:t1.val)+(t2==null?0:t2.val));
    	node.left = mergeTrees(t1==null?null:t1.left, t2==null?null:t2.left);
    	node.right = mergeTrees(t1==null?null:t1.right, t2==null?null:t2.right);
		return node;
    }
}