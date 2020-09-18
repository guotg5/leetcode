package BinaryTree;

import com.sun.deploy.panel.ITreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.*;

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
	 * @Description 第k大节点  中序遍历
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
					//list.add(root.val);
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
		
		return list.get(list.size()-k);
    }

	/**
	 * 第k大 使用后序遍历
	 *
	 * @param root
	 * @param k
	 * @return
	 */
	public int kthLargest1(TreeNode root, int k) {
		Stack<TreeNode> v = new Stack<>();
		List<Integer> list = new ArrayList<>();
		while(root != null) {
			v.push(root);
			if(root.right!=null) {
				root = root.right;
			}else {
				list.add(root.val);
				if(v.size()>0) {
					root = v.pop();
					//list.add(root.val);
					while(root.left == null && v.size()>0) {
						root = v.pop();
						list.add(root.val);
					}
					if(root.left!=null) {
						root = root.left;
					}else {
						root = null;
					}
				}
			}
		}

		return list.get(list.size()-k);
	}

	/**
	 * 构造平衡二叉搜索树
	 *
	 * @param nums
	 * @return
	 */
	public TreeNode sortedArrayToBST(int[] nums) {
		if(nums == null || nums.length == 0)return null;

		int mid = (nums.length-1)/2;
		TreeNode node = new TreeNode(nums[mid]);
		node.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, mid));
		node.right = sortedArrayToBST(Arrays.copyOfRange(nums, mid+1, nums.length));

		return node;
	}

	TreeNode result = new TreeNode(0);
	TreeNode result1 = result;
	public TreeNode increasingBST(TreeNode root) {
		if(root != null){
			increasingBST(root.left);
			result.right = new TreeNode(root.val);
			result = result.right;
			increasingBST(root.right);
		}
		return result1.right;
	}

	public static void main(String[] args) {
		new RangeSumBST().increasingBST(TreeNode.convert(new int[]{5,3,6,2,4,0,8,1,0,0,0,7,9}));
	}
}