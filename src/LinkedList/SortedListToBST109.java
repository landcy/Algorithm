package LinkedList;

import static LinkedList.LinkedListUtil.buildListByArray;
import static LinkedList.LinkedListUtil.printLinkedList;

/**
 * TBD
 * 
 * 109. Convert Sorted List to Binary Search Tree
 * 
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 * 
 * @author landcy
 *
 */
public class SortedListToBST109 {

	public static TreeNode sortedListToBST(ListNode head) {
		return null;
	}

	public static void main(String[] args) {
		System.out.println(" 109. Convert Sorted List to Binary Search Tree ");
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
		// printLinkedList(reverseBetween(l1, m, n));
		System.out.println();
	}
}
