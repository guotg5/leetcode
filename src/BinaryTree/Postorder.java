package BinaryTree;

import java.util.ArrayList;
import java.util.List;

/** 
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 * 
 * @ClassName Postorder 
 * @Description TODO 
 * @author guotg
 * @date 2020-9-17 13:43:32 
 *  
 */
class Postorder {
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