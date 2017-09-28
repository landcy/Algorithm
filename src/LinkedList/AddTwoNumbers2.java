package LinkedList;

import static LinkedList.LinkedListUtil.buildListByArray;
import static LinkedList.LinkedListUtil.printLinkedList;;

/**
 * Add Two Numbers
 * 
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
 * 
 * @author landcy
 *
 */
public class AddTwoNumbers2 {
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
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
		runCase(new int[] { 2, 9, 9 }, new int[] { 1, 2, 3 });
		System.out.println("---------case 3---------");
		runCase(new int[] { 1 }, new int[] { 1, 2, 3 });
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