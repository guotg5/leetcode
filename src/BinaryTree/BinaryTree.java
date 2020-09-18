package BinaryTree;

import java.util.Stack;

/**
 * 二叉树的深度
 * 
 * @ClassName BinaryTree
 * @Description 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。 
 * @author guotg
 * @date 2020-9-16 16:22:46 
 *  
 */
class BinaryTree {
	int result = 0;
    public int maxDepth(TreeNode root) {
    	dfs(root, 0);
		return result;
    }
    
    /**
     * @Description 标准答案  巧妙的递归 ！！！
     *
     * @param root
     * @return
     */
    public int maxDepth1(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth1(root.left), maxDepth1(root.right)) + 1;
    }
    
    void dfs(TreeNode node, int dep) {
    	dep++;
    	if(node.left!=null) {
    		dfs(node.left, dep);
    	}
    	
    	if(node.right!=null) {
    		dfs(node.right, dep);
    	}
    	
    	if(node.left==null&&node.right==null&&result<dep) {
    		result = dep;
    	}
    }
    boolean pfind = false;
    boolean qfind = false;
	Stack<TreeNode> stack1 = new Stack<TreeNode>();
	Stack<TreeNode> stack2 = null;

	/**
	 * 最近公共祖先
	 *
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root != null){
			if(root.val == p.val){
				pfind = true;
			}else if(root.val == q.val){
				qfind = true;
			}

		}
		return root;
	}

	void dfs1(TreeNode root, TreeNode p, TreeNode q, Stack<TreeNode> stack){

	}
}