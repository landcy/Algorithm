package LinkedList;

import static LinkedList.LinkedListUtil.buildListByArray;
import static LinkedList.LinkedListUtil.printLinkedList;

/**
 * 61. Rotate List
 * 
 * Given a list, rotate the list to the right by k places, where k is
 * non-negative. For example: Given 1->2->3->4->5->NULL and k = 2, return
 * 4->5->1->2->3->NULL.
 * 
 * @author landcy
 *
 */
public class RotateList61 {
	public static ListNode rotateRight1(ListNode head, int k) {
		if (head == null || k <= 0 || head.next == null) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode fastRunner = dummy;
		ListNode slowRunner = dummy;
		for (int i = 0; i < k; i++) {
			if (fastRunner == null) {
				return head;
			} else {
				fastRunner = fastRunner.next;
			}
		}
		// warning : fastRunner.next = null, don't need to rotate. if rotate,
		// linked list will be a cycle.
		if (fastRunner == null || fastRunner.next == null) {
			return head;
		}
		while (fastRunner.next != null) {
			fastRunner = fastRunner.next;
			slowRunner = slowRunner.next;
		}
		ListNode slowNext = slowRunner.next;
		slowRunner.next = null;
		dummy.next = slowNext;
		fastRunner.next = head;
		return dummy.next;
	}

	public static int lengthOfLinkedList(ListNode head) {
		int k = 0;
		ListNode cur = head;
		while (cur != null) {
			k++;
			cur = cur.next;
		}
		return k;
	}

	public static ListNode rotateRight(ListNode head, int k) {
		if (head == null || k <= 0 || head.next == null) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode fastRunner = dummy;
		ListNode slowRunner = dummy;
		int length = lengthOfLinkedList(head);
		k = k > length ? k % length : k;
		for (int i = 0; i < k; i++) {
			if (fastRunner == null) {
				return head;
			} else {
				fastRunner = fastRunner.next;
			}
		}
		// warning : fastRunner.next = null, don't need to rotate. if rotate,
		// linked list will be a cycle.
		if (fastRunner == null || fastRunner.next == null) {
			return head;
		}
		while (fastRunner.next != null) {
			fastRunner = fastRunner.next;
			slowRunner = slowRunner.next;
		}
		ListNode slowNext = slowRunner.next;
		slowRunner.next = null;
		dummy.next = slowNext;
		fastRunner.next = head;
		return dummy.next;
	}

	public static void main(String[] args) {
		System.out.println("61. Rotate Listt ");
		System.out.println("---------case 0---------");
		runCase(null, 0);
		System.out.println("---------case 1---------");
		runCase(new int[] { 3 }, 1);
		System.out.println("---------case 2---------");
		runCase(new int[] { 1, 2, 3 }, 3);
		System.out.println("---------case 3---------");
		runCase(new int[] { 1 }, 2);
		System.out.println("---------case 4---------");
		runCase(new int[] { 2, 9, 9, 1 }, 3);
		System.out.println("---------case 5---------");
		runCase(new int[] { 2, 9, 9, 1 }, -3);
		System.out.println("---------case  6---------");
		runCase(new int[] { 1, 2 }, 3);
	}

	public static void runCase(int[] array, int n) {
		ListNode linkedlist = buildListByArray(array);
		System.out.print("input: ");
		printLinkedList(linkedlist);
		System.out.println("    " + n);
		System.out.println("result : ");
		printLinkedList(rotateRight(linkedlist, n));
		System.out.println();
	}
}
