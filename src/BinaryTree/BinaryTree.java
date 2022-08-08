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

	/**
	 * 二叉树先序遍历-非递归
	 *
	 * @param root
	 * @return
	 */
	public List<Integer> preorder(TreeNode root){
		Stack<TreeNode> stack = new Stack<>();
		List<Integer> list = new ArrayList<>();
		while(root != null || stack.size() > 0){
			if(root != null){
				list.add(root.val);
				stack.push(root);
				root = root.left;
			}else{
				root = stack.pop().right;
			}
		}
		return list;
	}

	/**
	 * 二叉树中序遍历-非递归
	 *
	 * @param root
	 * @return
	 */
	public List<Integer> inorder(TreeNode root){
		Stack<TreeNode> stack = new Stack<>();
		List<Integer> list = new ArrayList<>();
		while(root != null || stack.size() > 0){
			if(root != null){
				stack.push(root);
				root = root.left;
			}else{
				list.add(stack.peek().val);
				root = stack.pop().right;
			}
		}
		return list;
	}

	/**
	 * 二叉树后序遍历-非递归
	 * 双栈法
	 * @param root
	 * @return
	 */
	public List<Integer> postorder(TreeNode root){
		Stack<TreeNode> stack = new Stack<>();
		Stack<TreeNode> stack1 = new Stack<>();
		List<Integer> list = new ArrayList<>();
		if(root != null){
			stack.push(root);
			while(!stack.isEmpty()){
				root = stack.pop();
				stack1.push(root);
				if(root.left != null){
					stack.push(root.left);
				}
				if(root.right != null){
					stack.push(root.right);
				}
			}
			while (!stack1.isEmpty()){
				list.add(stack1.pop().val);
			}
		}
		return list;
	}

	/**
	 * 路径和
	 * @param root
	 * @param sum
	 * @return
	 */
	public boolean hasPathSum(TreeNode root, int sum) {
		if(root == null) return false;
		if(root.val == sum && root.left==null && root.right==null) return true;
		if(hasPathSum(root.left, sum-root.val)){
			return true;
		}
		if(hasPathSum(root.right, sum-root.val)){
			return true;
		}
		return false;
	}

	/**
	 * 从根到叶的二进制数之和
	 * @param root
	 * @return
	 */
	public int sumRootToLeaf(TreeNode root) {
		return sumRootToLeaf(root, 0);
	}

	int sumRootToLeaf(TreeNode root, int num){
		int sum = 0;
		if(root != null){
			num = num*2 + root.val;
			if(root.left != null)sum+=sumRootToLeaf(root.left, num);
			if(root.right != null)sum+=sumRootToLeaf(root.right, num);
			if(root.left == null && root.right == null)sum+=num;
		}
		return sum;
	}

	/**
	 *  对称的二叉树
	 *
	 * @param root
	 * @return
	 */
	public boolean isSymmetric(TreeNode root) {
		LinkedList<TreeNode> queue = new LinkedList<>();
		if(root!=null)queue.offer(root);
		int count = queue.size();
		while(queue.size()>0){
			LinkedList<Integer> deque = new LinkedList<>();
			//将一行数据val放入双端队列中
			for (int i = 0; i < count; i++) {
				TreeNode node = queue.poll();
				if(node == null){
					deque.offer(null);
				}else{
					deque.offer(node.val);
					queue.offer(node.left);
					queue.offer(node.right);
				}
			}
			count = queue.size();
			while(deque.size()>1){
				if(deque.poll()!=deque.pollLast()){
					return false;
				}
			}
		}
		return true;
	}

	public boolean isSymmetric_digui(TreeNode root) {

		return digui(root.left, root.right);
	}

	boolean digui(TreeNode p, TreeNode q){
		if(p == null && q == null)return true;
		if(p == null || q == null)return false;
		if(p.val != q.val)return false;
		return digui(p.left,q.right)?digui(p.right,q.left):false;
	}

	/**
	 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
	 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
	 * 示例 1:
	 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
	 * Output: [3,9,20,null,null,15,7]
	 **/
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if(preorder==null||preorder.length==0)return null;
		int i = 0;
		int rootindex = -1;
		while(rootindex == -1){
			rootindex = findIndex(inorder, preorder[i++]);
		}
		TreeNode rootNode = new TreeNode(inorder[rootindex]);
		if(preorder.length>1){
			if(rootindex!=0) {
			    preorder = Arrays.copyOfRange(preorder,1, preorder.length);
                rootNode.left = buildTree(preorder ,Arrays.copyOfRange(inorder,0,rootindex));
            }
			if(rootindex+1<inorder.length)
				rootNode.right = buildTree(Arrays.copyOfRange(preorder,1, preorder.length),
                        Arrays.copyOfRange(inorder, rootindex+1, inorder.length));
		}
		return rootNode;
	}

	int findIndex(int[] arr, int value){
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == value){
				return i;
			}
		}
		return -1;
	}

	/**
	 * 100. 相同的树
	 *
	 * @param p
	 * @param q
	 * @return
	 */
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p == null && q == null)return true;
		if(p == null || q == null)return false;
		if(p.val != q.val)return false;
		return isSameTree(p.left, q.left)?isSameTree(p.right, q.right):false;
	}

	/**
	 * @param root
	 * @return
	 */
	public int sumNumbers(TreeNode root) {
		if(root==null)return 0;
		int sum = 0;
		Queue<Integer> stack = new ArrayDeque<>();
		Queue<TreeNode> nodes = new ArrayDeque<>();

		nodes.offer(root);
		stack.offer(root.val);
		while (!nodes.isEmpty()){
			int len = nodes.size();
			for (int i = 0; i < len; i++) {
				TreeNode node = nodes.poll();
				Integer val = stack.poll();
				if(node.left==null&&node.right==null){
					sum+=val;
				}else{
					if (node.left!=null){
						nodes.offer(node.left);
						stack.offer(val*10+node.left.val);
					}
					if (node.right!=null){
						nodes.offer(node.right);
						stack.offer(val*10+node.right.val);
					}
				}
			}
		}

		return sum;
	}

	public static void main(String[] args) {
		new BinaryTree().buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
	}
}