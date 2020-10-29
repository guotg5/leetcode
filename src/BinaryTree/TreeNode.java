package BinaryTree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    public static TreeNode convert(int[] arr) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode node = new TreeNode(arr[0]);
        queue.offer(node);
        int i = 1;
        while(i < arr.length) {
            TreeNode n1 = queue.poll();
            if(arr[i] != 0){
                n1.left = new TreeNode(arr[i]);
                queue.offer(n1.left);
            }
            i++;
            if(i >= arr.length)break;

            if(arr[i] != 0){
                n1.right = new TreeNode(arr[i]);
                queue.offer(n1.right);
            }
            i++;
        }
        return node;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String result = null;
        if(root != null){
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int nullcount = 0;
            while (queue.size() > 0 && queue.size() > nullcount){
                int len = queue.size();
                nullcount = 0;
                for (int i = 0; i < len; i++){
                    TreeNode temp = queue.poll();
                    String value = "null";
                    if(temp != null){
                        value = String.valueOf(temp.val);
                        queue.offer(temp.left);
                        queue.offer(temp.right);
                        if(temp.left == null)nullcount++;
                        if(temp.right == null)nullcount++;
                    }
                    if(result == null){
                        result = value;
                    }else{
                        result += (","+value);
                    }
                }
            }
        }

        return result;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.substring(1,data.length()-1).split(",");

        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode node = new TreeNode(Integer.valueOf(arr[0]));
        queue.offer(node);
        int i = 1;
        while(i < arr.length) {
            TreeNode n1 = queue.poll();
            if(!"null".equals(arr[i])){
                n1.left = new TreeNode(Integer.valueOf(arr[i]));
                queue.offer(n1.left);
            }
            i++;
            if(i >= arr.length)break;

            if(!"null".equals(arr[i])){
                n1.right = new TreeNode(Integer.valueOf(arr[i]));
                queue.offer(n1.right);
            }
            i++;
        }
        return node;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1).deserialize("[1,2,3,null,null,4,5]");
        node.serialize(node);
    }
}