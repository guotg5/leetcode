package BinaryTree;

import java.util.ArrayDeque;
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
 }