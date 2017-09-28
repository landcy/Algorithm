package LinkedList;

import static LinkedList.LinkedListUtil.buildListByArray;
import static LinkedList.LinkedListUtil.printLinkedList;

/**
 * 24. Swap Nodes in Pairs
 * 
 * Given a linked list, swap every two adjacent nodes and return its head. For
 * example, Given 1->2->3->4, you should return the list as 2->1->4->3. Your
 * algorithm should use only constant space. You may not modify the values in
 * the list, only nodes itself can be changed.
 * 
 * @author landcy
 *
 */
public class SwapNodesinPairs24 {
	public static ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy;
		ListNode cur = head;
		ListNode then = head.next;
		while (then != null) {
            pre.next = then;
            cur.next = then.next;
            then.next = cur;
            pre = cur;
            cur = pre.next;
            then = cur == null ? null : cur.next;
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		System.out.println("24. Swap Nodes in Pairs  ： ");
		System.out.println("---------case 0---------");
		runCase(null);
		System.out.println("---------case 1---------");
		runCase(new int[] { 1 });
		System.out.println("---------case 2---------");
		runCase(new int[] { 1, 2, 3, 4, 5 });
		System.out.println("---------case 3---------");
		runCase(new int[] { 1, 2, 3, 4 });
	}

	public static void runCase(int[] array1) {
		ListNode l1 = buildListByArray(array1);
		System.out.println("input : ");
		printLinkedList(l1);
		System.out.println();
		System.out.println("result : ");
		printLinkedList(swapPairs(l1));
		System.out.println();
	}
}
