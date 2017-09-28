package LinkedList;

public class LinkedListUtil {
	private LinkedListUtil() {
	}

	public static ListNode buildListByArray(int[] array) {
		if (array == null) {
			return null;
		}
		ListNode head = new ListNode(0);
		ListNode cur = head;
		for (int val : array) {
			cur.next = new ListNode(val);
			cur = cur.next;
		}
		return head.next;
	}

	public static void printLinkedList(ListNode head) {
		if (head == null) {
			System.out.print("null");
			return;
		}
		ListNode cur = head;
		StringBuffer sb = new StringBuffer();
		while (cur.next != null) {
			sb.append(cur.val + "->");
			cur = cur.next;
		}
		if (cur != null) {
			sb.append(cur.val);
		}
		System.out.print(sb.toString());
	}
}
