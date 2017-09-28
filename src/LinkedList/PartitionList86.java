package LinkedList;

import static LinkedList.LinkedListUtil.buildListByArray;
import static LinkedList.LinkedListUtil.printLinkedList;

/*
 * 86. Partition List 
 * 
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x. 
 * You should preserve the original relative order of the nodes in each of the two partitions. 
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5. 
 */
public class PartitionList86 {
   public static ListNode partition(ListNode head, int x) {
        if( head == null ) { 
        	return head;
        }
		ListNode cur = head;
		ListNode lh = null;
		ListNode le = null;
		ListNode rh = null;
		ListNode re = null;
		while ( cur != null ) {
			if( cur.val < x ) {
				if ( lh == null ) {
					lh = cur;
					le = lh;
				} else {
					le.next = cur;
					le = le.next;
				}
			} else { 
				if ( rh == null ) {
					rh = cur;
					re = rh;
				} else {
					re.next = cur;
					re = re.next;
				}
			}
			cur = cur.next;
		}
		if ( lh == null ) { 
			return rh;
		} else {
			le.next = rh;
			return lh;
		}
    }
   public static void main(String[] args) {
		System.out.println("86. Partition List ");
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
		printLinkedList(partition(linkedlist, n));
		System.out.println();
	}
	
}
