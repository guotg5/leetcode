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
				node = node.next;
			}
		}
		return head;
	}

	/**
	 * 快慢指针找从尾数第k个节点
	 **/
	public ListNode findKthToTail(ListNode head, int k) {
		ListNode fast = head;
		ListNode slow = head;
		while(fast != null) {
			fast = fast.next;
			if(k == 0) {
				slow = slow.next;
			} else {
				k--;
			}
		}
		return k==0? slow : null;
	}

	/**
	 * 快慢指针证明有环
	 **/
	public ListNode ifCycle(ListNode head) {
		if(head == null) return null;
		ListNode fast = head;
		ListNode slow = head;

		while(fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if(fast.equals(slow)) return fast;
		}
		return null;
	}

	/**
	 * 找环的入口
	 * 起点---n(入口)---a(相遇点)---b(剩余长度)
	 * 已知 2(n+a) = n+a+x(a+b)
	 *     n = b-a-b + x(a+b) = b + (x-1)(a+b)
	 **/
	public ListNode findMeetNode(ListNode head) {
		if(head == null) return null;
		ListNode fast = head;
		ListNode slow = head;
		boolean meet = false;

		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			if(meet){
				fast = fast.next;
			}else {
				fast = fast.next.next;
			}
			if(slow.equals(fast)) {
				if(meet || fast.equals(head)){
					return fast;
				}else {
					meet = true;
					slow = head;
				}
			}
		}
		return null;
	}

	public static void main(String[] args) {
		reverseList(ListNode.convert(new int[]{1,2,3,4,5}));
	}

	ListNode root = null;

	public static ListNode reverseList(ListNode head) {
		if(head == null || head.next == null){
			return head;
		}

		ListNode result = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return result;
	}

	public static ListNode mergeListNode(ListNode l1, ListNode l2) {
		if(l1 == null) return l2;
		if(l2 == null) return l1;


		ListNode resultHead = new ListNode(0);
		ListNode result = resultHead;
		while(true) {
			if(l1 == null || l2 == null) {
				result.next = l1 == null? l2 : l1;
				break;
			}
			if(l1.val < l2.val) {
				result.next = l1;
				l1 = l1.next;
			} else {
				result.next = l2;
				l2 = l2.next;
			}
			result = result.next;
		}
		return resultHead.next;
	}

	public ListNode deleteNode(ListNode head, int val) {
		ListNode node = new ListNode(0);
		ListNode result = node;
		node.next = head;
		while(node.next != null) {
			if(node.next.val == val) {
				node.next = node.next.next;
				break;
			}
			node = node.next;
		}
		return result.next;
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

	public static class Node {
		int val;
		Node next;
		Node random;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}
}