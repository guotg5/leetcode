package BinaryTree;

import com.sun.deploy.panel.ITreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.*;

/** 
 * 二叉搜索树
 */
class BST {

	/**
	 * 二叉搜索树范围和
	 * @param root
	 * @param L
	 * @param R
	 * @return
	 */
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

	/**
	 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
	 * 遍历找到节点既大于等于p 又小于等于q即可
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(p.val>q.val){
			TreeNode temp = p;
			p = q;
			q = temp;
		}
		if(root != null){
			if(root.val>=p.val&&root.val<=q.val){
				return root;
			}else{
				TreeNode left = lowestCommonAncestor(root.left,p,q);
				return left!=null?left:lowestCommonAncestor(root.right,p,q);
			}
		}
		return null;
	}

	public static void main(String[] args) {
		new BST().increasingBST(TreeNode.convert(new int[]{5,3,6,2,4,0,8,1,0,0,0,7,9}));
	}
}