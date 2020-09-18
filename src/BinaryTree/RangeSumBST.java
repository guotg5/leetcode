package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

/** 
 * 二叉搜索树范围和
 * 
 * @ClassName RangeSumBST 
 * @Description 给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。
 * @author guotg
 * @date 2020-9-16 17:36:39 
 *  
 */
class RangeSumBST {
	public int rangeSumBST(TreeNode root, int L, int R) {
		if(root == null)return 0;
		int val = root.val;
		if(val<L) {
			return rangeSumBST(root.right, L, R);
		}else if(val>R){
			return rangeSumBST(root.left, L, R);
		}

		return val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
	}

	/**
	 * @Description 给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NUL
	 *
	 * @param root
	 * @param val
	 * @return
	 */
	public TreeNode searchBST(TreeNode root, int val) {
		if(root != null) {
			if(root.val == val)return root;
			TreeNode left = searchBST(root.left, val);
			if(left != null) {
				return left;
			}
			TreeNode right = searchBST(root.right, val);
			if(right != null) {
				return right;
			}
		}
		return null;
	}
	
	/**
	 * @Description 第k大节点
	 *
	 * @param root
	 * @param k
	 * @return
	 */
	public int kthLargest(TreeNode root, int k) {
		Stack<TreeNode> v = new Stack<>();
		List<Integer> list = new ArrayList<>();
		while(root != null) {
			v.push(root);
			if(root.left!=null) {
				root = root.left;
			}else {
				list.add(root.val);
				if(v.size()>0) {
					root = v.pop();
					list.add(root.val);
					while(root.right == null && v.size()>0) {
						root = v.pop();
						list.add(root.val);
					}
					if(root.right!=null) {
						root = root.right;
					}else {
						root = null;
					}
					
				}
			}
		}
		
		return list.get(k-1);
    }
}