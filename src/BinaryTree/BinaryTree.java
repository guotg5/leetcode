package BinaryTree;

import java.util.*;
import java.util.stream.IntStream;

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
	Deque<TreeNode> stack1 = new ArrayDeque<>();
	Deque<TreeNode> stack2 = new ArrayDeque<>();

	/**
	 * 最近公共祖先
	 *
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(p.val == q.val){
			return p;
		}
		dfs1(root, p, q, new ArrayDeque<TreeNode>());
		TreeNode result = null;
		while(stack1.size()>0 && stack2.size()>0&&stack1.peekFirst()==stack2.peekFirst()){
			result = stack1.poll();
			stack2.poll();
		}
		return result;
	}

	void dfs1(TreeNode root, TreeNode p, TreeNode q, Deque<TreeNode> stack){
		if((stack1.size() == 0 || stack2.size() == 0) && root != null){
			stack.offer(root);
			if(root.val == p.val){
				stack1.addAll(stack);
			}
			if(root.val == q.val){
				stack2.addAll(stack);
			}
			dfs1(root.left, p, q, stack);
			dfs1(root.right, p, q, stack);
			stack.remove(root);
		}
	}

	public List<Double> averageOfLevels(TreeNode root) {
		List<Double> list = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		list.add(Double.valueOf(root.val));
		while(queue.size()>0){
			double sum = 0;
			int count = 0;
			for (int i = 0; i < queue.size(); i++) {
				TreeNode node = queue.poll();
				if(node == null)continue;
				sum += node.val;
				count++;
				if(node.left!=null){
					queue.offer(node.left);
				}
				if(node.right!=null){
					queue.offer(node.right);
				}
			}
			list.add(sum/count);
		}
		return list;
	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if(root != null) {
			Deque<TreeNode> queue = new ArrayDeque<>();
			queue.offer(root);
			while (queue.size()>0){
				int len = queue.size();
				List<Integer> list = new ArrayList<>(len);
				for (int i = 0; i < len; i++) {
					TreeNode node = queue.poll();
					list.add(node.val);
					if(node.left != null)queue.offer(node.left);
					if(node.right != null)queue.offer(node.right);
				}
				result.add(list);
			}

		}
		return result;
	}

	/**
	 * 填充每个节点的下一个右侧节点指针 II
	 * 利用next指针 可以不使用队列存储 实现层序遍历即BFS（宽度优先遍历）
	 * @param root
	 * @return
	 */
	public Node connect(Node root) {
		Node pre = root;
		Node curr = null;
		Node begin = null;
		while(pre!=null){
			if(pre.left!=null){
				if(curr!=null){
					curr.next = pre.left;
					curr = curr.next;
				}else{
					curr = pre.left;
					begin = curr;
				}
			}
			if(pre.right!=null){
				if(curr!=null){
					curr.next = pre.right;
					curr = curr.next;
				}else{
					curr = pre.right;
					begin = curr;
				}
			}
			if (pre.next == null) {
				pre = begin;
				curr = null;
				begin = null;
			}else{
				pre = pre.next;
			}
		}

		return root;
	}

	public int findTilt(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		findTilt_dfs(root, list);
		return list.stream().mapToInt(Integer::valueOf).sum();
	}

	private int findTilt_dfs(TreeNode root, List<Integer> list){
		if(root == null)return 0;
		list.add(Math.abs(findTilt(root.left)+(root.left==null?0:root.left.val)-findTilt(root.right)-(root.right==null?0:root.right.val)));
		return 0;
	}

	List<Integer> list_digui = new ArrayList<>();
	public List<Integer> postorderTraversal_digui(TreeNode root){
		if(root != null){
			postorderTraversal_digui(root.left);
			postorderTraversal_digui(root.right);
			list_digui.add(root.val);
		}
		return list_digui;
	}

	public List<Integer> postorderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		List<Integer> list = new ArrayList<>();
		while (root != null){
			stack.push(root);

			if(root.left != null){
				stack.push(root.left);
				root = root.left;
			}else if(root.right != null){
				stack.push(root.right);
				root = root.right;
			}else{
				list.add(root.val);
				root = stack.pop();
				while(stack.size()>0&&stack.peek().right==null){
					root = stack.pop();
					list.add(root.val);
				}
				if(stack.size()>0){
					root = stack.peek().right;
				}
			}

		}

		return list;
	}

	public static void main(String[] args) {
		new BinaryTree().lowestCommonAncestor(TreeNode.convert(new int[]{6,2,8,0,4,7,9,0,0,3,5}),new TreeNode(2),new TreeNode(4));
	}
}