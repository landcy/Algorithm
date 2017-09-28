package LinkedList;

import static LinkedList.LinkedListUtil.buildListByArray;
import static LinkedList.LinkedListUtil.printLinkedList;

/**
 *  83. Remove Duplicates from Sorted List
 *  
 * Given a sorted linked list, delete all duplicates such that each element
 * appear only once. 
 * For example, 
 * Given 1->1->2, return 1->2. 
 * Given 1->1->2->3->3, return 1->2->3.
 * 
 * @author landcy
 *
 */
public class RemoveDuplicates83 {
	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy;
		ListNode cur = head;
		while (cur != null) {
			while (cur.next != null && cur.val == cur.next.val) {
				cur = cur.next;
			}
			if (pre.next == cur) {
				pre = pre.next;
			} else {
				pre.next = cur;
				pre = pre.next;
			}
			cur = cur.next;
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		System.out.println(" 83. Remove Duplicates from Sorted List  ： ");
		System.out.println("---------case 0---------");
		runCase(null);
		System.out.println("---------case 1---------");
		runCase(new int[] { 1 });
		System.out.println("---------case 2---------");
		runCase(new int[] { 1, 1, 1, 2, 2 });
		System.out.println("---------case 3---------");
		runCase(new int[] { 1, 2, 3, 4 });
		System.out.println("---------case 4---------");
		runCase(new int[] { 1, 2, 2, 3, 4 });
	}

	public static void runCase(int[] array1) {
		ListNode l1 = buildListByArray(array1);
		System.out.println("input : ");
		printLinkedList(l1);
		System.out.println();
		System.out.println("result : ");
		printLinkedList(deleteDuplicates(l1));
		System.out.println();
	}
}
