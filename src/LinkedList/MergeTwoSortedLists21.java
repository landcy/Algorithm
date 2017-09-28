package LinkedList;

import static LinkedList.LinkedListUtil.buildListByArray;
import static LinkedList.LinkedListUtil.printLinkedList;

/**
 * 21. Merge Two Sorted Lists
 * 
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 * 
 * @author landcy
 *
 */
public class MergeTwoSortedLists21 {
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null || l2 == null) {
			return l1 == null ? l2 : l1;
		}
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				cur.next = l1;
				cur = cur.next;
				l1 = l1.next;
			} else {
				cur.next = l2;
				cur = cur.next;
				l2 = l2.next;
			}
		}
		if (l1 != null) {
			cur.next = l1;
		}
		if (l2 != null) {
			cur.next = l2;
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		System.out.println("21. Merge Two Sorted Lists ： ");
		System.out.println("---------case 0---------");
		runCase(null, null);
		System.out.println("---------case 1---------");
		runCase(null, new int[] { 1, 2, 3 });
		System.out.println("---------case 2---------");
		runCase(new int[] { 1, 3, 4, 6 }, new int[] { 8, 12, 30 });
		System.out.println("---------case 3---------");
		runCase(new int[] { 1 }, new int[] { 8, 20, 30 });
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
		printLinkedList(mergeTwoLists(l1, l2));
		System.out.println();
	}
}
