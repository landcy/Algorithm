package LinkedList;

import static LinkedList.LinkedListUtil.buildListByArray;
import static LinkedList.LinkedListUtil.printLinkedList;

/**
 * 19. Remove Nth Node From End of List
 * 
 * Given a linked list, remove the nth node from the end of list and return its
 * head. For example, Given linked list: 1->2->3->4->5, and n = 2.
 * 
 * After removing the second node from the end, the linked list becomes
 * 1->2->3->5. Note: Given n will always be valid. Try to do this in one pass.
 * 
 * @author landcy
 *
 */
public class RemoveNthNode19 {
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null || n <= 0) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode fastRunner = dummy;
		ListNode slowRunner = dummy;
		//dummy->1 n =2 
		for (int i = 0; i < n; i++) {
			if (fastRunner == null) {
				return head;
			} else {
				fastRunner = fastRunner.next;
			}
		}
		//fastRunner = null 
		if (fastRunner == null) {
			return head;
		}
		while (fastRunner.next != null) {
			fastRunner = fastRunner.next;
			slowRunner = slowRunner.next;
		}
		slowRunner.next = slowRunner.next == null ? null : slowRunner.next.next;
		return dummy.next;
	}

	public static void main(String[] args) {
		System.out.println("19. Remove Nth Node From End of List ");
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
	}

	public static void runCase(int[] array, int n) {
		ListNode linkedlist = buildListByArray(array);
		System.out.print("input: ");
		printLinkedList(linkedlist);
		System.out.println("    " + n);
		System.out.println("result : ");
		printLinkedList(removeNthFromEnd(linkedlist, n));
		System.out.println();
	}
}
