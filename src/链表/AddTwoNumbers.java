package 链表;
/** 
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 
 * @ClassName AddTwoNumbers 
 * @Description TODO 
 * @author guotg
 * @date 2020-9-10 18:50:00 
 */
class AddTwoNumbers {
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = new ListNode(0);
		int jw = 0;
		ListNode r2 = new ListNode(0);
		r2.next = result;
		while(l1 != null || l2 != null || jw != 0) {
			if(r2.next == null)r2.next = new ListNode(0);
			r2 = r2.next;
			int a = 0; int b = 0;
			if(l1 != null) {
				a = l1.val;
			}
			if(l2 != null) {
				b = l2.val;
			}
			int sum = a + b + jw;
			r2.val = sum%10;
			if(sum > 9) {
				jw = 1;
			}else {
				jw = 0;
			}
			
			
			l1 = l1.next;
			l2 = l2.next;
		}
		
		return result;
	}


	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
}