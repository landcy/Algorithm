package LinkedList;

import static LinkedList.LinkedListUtil.buildListByArray;
import static LinkedList.LinkedListUtil.printLinkedList;

/**
 * 445.Add Two Numbers II
 * 
 * You are given two non-empty linked lists representing two non-negative
 * integers. The most significant digit comes first and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself. Follow up: What if you cannot modify the input lists? In
 * other words, reversing the lists is not allowed. Example: Input: (7 -> 2 -> 4
 * -> 3) + (5 -> 6 -> 4) Output: 7 -> 8 -> 0 -> 7
 * 
 * @author landcy
 *
 */
public class AddTwoNumbers445 {
	public static ListNode revertLinkedList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode pre = null;
		ListNode cur = head;
		while (cur != null) {
			ListNode node = cur.next;
			cur.next = pre;
			pre = cur;
			cur = node;
		}
		return pre;
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null || l2 == null) {
			return l1 == null ? l2 : l1;
		}
		l1 = revertLinkedList(l1);
		l2 = revertLinkedList(l2);
		ListNode result = addTwoNumbersCore(l1, l2);
		l1 = revertLinkedList(l1);
		l2 = revertLinkedList(l2);
		return revertLinkedList(result);
	}

	public static ListNode addTwoNumbersCore(ListNode l1, ListNode l2) {
		if (l1 == null || l2 == null) {
			return l1 == null ? l2 : l1;
		}
		ListNode head = new ListNode(0);
		ListNode p1 = l1;
		ListNode p2 = l2;
		int over = 0;
		ListNode cur = head;
		while (p1 != null || p2 != null || over > 0) {
			int value = (p1 == null ? 0 : p1.val) + (p2 == null ? 0 : p2.val) + over;
			if (value >= 10) {
				over = 1;
				value -= 10;
			} else {
				over = 0;
			}
			p1 = p1 == null ? null : p1.next;
			p2 = p2 == null ? null : p2.next;
			ListNode node = new ListNode(value);
			cur.next = node;
			cur = cur.next;
		}
		return head.next;
	}

	public static void main(String[] args) {
		System.out.println("Add Two Numbers");
		System.out.println("---------case 0---------");
		runCase(null, null);
		System.out.println("---------case 1---------");
		runCase(null, new int[] { 1, 2, 3 });
		System.out.println("---------case 2---------");
		runCase(new int[] { 2, 9, 9, 1 }, new int[] { 8, 2, 3 });
		System.out.println("---------case 3---------");
		runCase(new int[] { 1 }, new int[] { 8, 2, 3 });
	}

	public static void runCase(int[] array1, int[] array2) {
		ListNode l1 = buildListByArray(array1);
		ListNode l2 = buildListByArray(array2);
		System.out.println("input : ");
		printLinkedList(l1);
		System.out.print("   ");
		printLinkedList(l2);
		System.out.println();
		System.out.println("result : ");
		printLinkedList(addTwoNumbers(l1, l2));
		System.out.println();
	}
}
