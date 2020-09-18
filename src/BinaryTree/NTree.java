package BinaryTree;

import java.util.ArrayList;
import java.util.List;

/** 
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 * 
 * @ClassName NTree
 * @Description TODO 
 * @author guotg
 * @date 2020-9-17 13:43:32 
 *  
 */
class NTree {
	List<Integer> list= new ArrayList<>();
	
    public List<Integer> postorder(Node root) {
    	if(root != null) {
    		if(root.children != null) {
    			for(Node c : root.children) {
    				postorder(c);
    			}
    		}
    		list.add(root.val);
    	}
    	
		return list;
    }

    /**
     * 前序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {
        if(root != null){
            list.add(root.val);
            if (root.children != null){
                for (Node node : root.children){
                    preorder(node);
                }
            }
        }
        return list;
    }

    /**
     * 最大深度
     *
     * @param root
     * @return
     */
    public int maxDepth(Node root) {
        if(root == null) return 0;
        int max = 0;
        if(root.children != null){
            for (Node node : root.children){
                int result = maxDepth(node);
                if(result > max)max = result;
            }
        }
        return max + 1;
    }
    
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}