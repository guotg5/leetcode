package linkedList;

import java.util.*;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 
 * @ClassName AddTwoNumbers 
 * @Description TODO 
 * @author guotg
 * @date 2020-9-10 18:50:00 
 */
public class AddTwoNumbers {
	
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

	public static void reorderList(ListNode head) {
		ListNode result = head;
		Deque<ListNode> deque = new ArrayDeque<>();
		boolean first = false;
		while(head!=null){
			deque.offerLast(head);
			head = head.next;
		}
		head = result;
		while(!deque.isEmpty()){
			ListNode temp = head.next;
			head.next = deque.pollLast();
			deque.pollLast();
			head.next.next = temp;
			head = temp;
		}
		if(head!=null)head.next = null;
		head = result;
	}

	public ListNode middleNode(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while(slow!=null&&slow.next!=null&&fast!=null&&fast.next!=null){
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	/**
	 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）
	 **/
	public int[] reversePrint(ListNode head) {
		List<Integer> result = new ArrayList<>();
		reversePrint(head, result);
		return result.stream().mapToInt(Integer::valueOf).toArray();
	}

	private void reversePrint(ListNode head, List<Integer> result) {
		if(head == null) return;
		reversePrint(head.next, result);
		result.add(head.val);
	}

	public void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}

	public ListNode deleteDuplication(ListNode head) {
		if(head == null || head.next == null)return head;
		Set<Integer> set = new HashSet<>();
		ListNode node = head;
		set.add(node.val);
		while(node.next != null) {
			ListNode curr = node.next;
			if(set.contains(curr.val)) {
				node.next = node.next.next;
			}else {
				set.add(curr.val);
			}
			node = node.next;
		}
		return head;
	}

	public static void main(String[] args) {
		reorderList(ListNode.convert(new int[]{1,2,3,4,5}));
	}
	ListNode root = null;

	public ListNode reverseList(ListNode head) {
		if(head.next == null){
			return head;
		}

		return reverseList(head);
	}

	public static class ListNode {
		public int val;
		public ListNode next;
		public ListNode(int x) { val = x; }
		public ListNode(int val, ListNode next) { this.val = val; this.next = next; }


		public static ListNode convert(int[] arr){
			ListNode node = new ListNode(arr[0]);
			ListNode result = node;
			for (int i=1;i<arr.length;i++){
				node.next = new ListNode(arr[i]);
				node = node.next;
			}
			return result;
		}

		public String toString() {
		    return String.valueOf(val);
		}
	}
}