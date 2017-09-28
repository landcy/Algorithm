package LinkedList;

import static LinkedList.LinkedListUtil.buildListByArray;
import static LinkedList.LinkedListUtil.printLinkedList;

/**
 * 92. Reverse Linked List II
 * 
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * For example: 
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4, 
 * return 1->4->3->2->5->NULL. 
 * Note: Given m, n satisfy the following condition: 1 ≤ m
 * ≤ n ≤ length of list.
 * 
 * @author landcy
 *
 */
public class ReverseLinkedList92 {

	public static ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null || m <= 0) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		// pre : if m = 1
		ListNode pre = dummy;
		ListNode tail = null;
		ListNode cur = head;
		for (int i = 1; i < n; i++) {
			if (cur == null) {
				return head;
			} else {
				if (i == (m - 1)) {
					pre = cur;
				}
				cur = cur.next;
			}
		}

		tail = cur;
		if (pre == null || pre.next == null || tail == null) {
			return head;
		}
		ListNode re_tail = pre.next;
		ListNode head2 = pre.next;
		ListNode then = tail.next;
		tail.next = null;
		ListNode re = reverse(head2);
		pre.next = re;
		re_tail.next = then;
		return dummy.next;
	}

	public static ListNode reverse(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode pre = null;
		ListNode cur = head;
		while (cur != null) {
			ListNode then = cur.next;
			cur.next = pre;
			pre = cur;
			cur = then;
		}
		return pre;
	}

	public static void main(String[] args) {
		System.out.println("92. Reverse Linked List II");
		System.out.println("---------case 0---------");
		runCase(null, 1, 2);
		System.out.println("---------case 1---------");
		runCase(new int[] { 1, 2, 3, 4, 5 }, 1, 7);
		System.out.println("---------case 2---------");
		runCase(new int[] { 1, 2, 3, 4, 5 }, 5, 6);
		System.out.println("---------case 3---------");
		runCase(new int[] { 1, 2, 3, 4, 5 }, -1, 0);
		System.out.println("---------case 4---------");
		runCase(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 }, 2, 6);
		System.out.println("---------case 4---------");
		runCase(new int[] { 3, 5 }, 1, 2);
	}

	public static void runCase(int[] array, int m, int n) {
		ListNode l1 = buildListByArray(array);
		System.out.println("input : ");
		printLinkedList(l1);
		System.out.print("   m = " + m + "  n = " + n);
		System.out.println();
		System.out.println("result : ");
		printLinkedList(reverseBetween(l1, m, n));
		System.out.println();
	}
}
