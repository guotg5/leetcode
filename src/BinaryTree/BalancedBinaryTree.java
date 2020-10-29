package BinaryTree;

/**
 * 平衡二叉树相关
 */
public class BalancedBinaryTree {

    /**
     * 判断二叉树是否平衡
     *
     * @param root
     * @return 是否
     */
    boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return isBalanced;
    }

    int dfs(TreeNode root){
        if(isBalanced == false || root == null){
            return 0;
        }else{
            int left = dfs(root.left);
            int right = dfs(root.right);
            if(Math.abs(left - right) > 1)isBalanced = false;
            return Math.max(left, right) + 1;
        }
    }

    public static void main(String[] args) {
        new BalancedBinaryTree().isBalanced(TreeNode.convert(new int[]{1,2,2,3,3,0,0,4,4}));
    }
}
