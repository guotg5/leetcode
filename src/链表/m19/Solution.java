package 链表.m19;

import 链表.AddTwoNumbers.ListNode;

class Solution {
    //1 2 3 4 5
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode result = new ListNode(1, head);
        ListNode low = result;
        ListNode fast = result;
        while(fast.next != null){
            fast = fast.next;
            if(n == 0){
                low = low.next;
            }else n--;
        }
        if(low.next != null) low.next = low.next.next;
        return result.next;
    }

    public static void main(String[] args) {
        new Solution().removeNthFromEnd(ListNode.convert(new int[] {1}), 1);
    }
}