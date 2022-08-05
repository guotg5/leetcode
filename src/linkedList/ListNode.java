package linkedList;

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }

     public static ListNode convert(int[] arr, int pos){
         ListNode root = null;
         ListNode temp = null;
         ListNode posNode = null;
         for (int i = 0; i < arr.length; i++) {
             if(i == 0){
                 root = new ListNode(arr[i]);
                 temp = root;
             }else{
                 temp.next = new ListNode(arr[i]);
                 temp = temp.next;
             }
             if(i == pos){
                 posNode = temp;
             }
         }
         temp.next = posNode;
         return root;
     }
 }