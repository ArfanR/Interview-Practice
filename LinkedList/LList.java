import java.util.*;

class LinkedListNode {

    public Object data;
   	public LinkedListNode next;

   	public LinkedListNode(Object data) {
   		this.data = data;
   	}
}

public class LList {

	// Time complexity: O(n)
	// Use hash set to check for duplicates
	public static LinkedListNode deleteDups(LinkedListNode n) {
		HashSet<Object> set = new HashSet<Object>();
		LinkedListNode previous = null;
		while (n != null) {
			if (set.contains(n.data)) {
				previous.next = n.next;
			}
			else {
				set.add(n.data);
				previous = n;
			}
			n = n.next;
		}

		return previous;
	}

	// Time complexity: O(n)
	// Recursive solution for kth to last
	class Index {
		public int value = 0;
	}

	LinkedListNode kthToLast(LinkedListNode head, int k) {
		Index idx = new Index();
		return kthToLast(head, k, idx);
	}

	LinkedListNode kthToLast(LinkedListNode head, int k, Index idx) {
		if (head == null) {
			return null;
		}
		LinkedListNode node = kthToLast(head.next, k, idx);
		idx.value += 1;
		if (idx.value == k) {
			return head;
		}
		return node;
	}
	// Time complexity: O(n)
	// Iterative solution for kth to last
	LinkedListNode nthToLast(LinkedListNode head, int k) {
		LinkedListNode p1 = head;
		LinkedListNode p2 = head;

		for (int i = 0; i < k; i++) {
			if (p1 == null) return null;
			p1 = p1.next;
		}

		while (p1 != null) {
			p1 = p1.next;
			p2 = p2.next;
		}

		return p2;
	}

	// Time complexity: O(n)
	// Delete middle node 
	public static boolean deleteNode(LinkedListNode n) {
		if (n == null || n.next == null) {
			return false;
		}
		LinkedListNode next = n.next;
		n.data = next.data;
		n.next = next.next;
		return true;
	}

	// Time Complexity: O(n)
	// Rearrange nodes into two linkedlists
	LinkedListNode partition(LinkedListNode node, int x) {
		LinkedListNode before = node;
		LinkedListNode after = node;

		while (node != null) {
			LinkedListNode next = node.next;
			if (node.data < x) {
				node.next = before;
				before = node;
			}
			else {
				after.next = node;
				after = node;
			}
			node = next;
		}
		after.next = null;

		return before;
	}

	public static void main(String[] args) {
		LinkedListNode node_1 = new LinkedListNode("first");        
        LinkedListNode node_2 = new LinkedListNode("second");
        node_1.next = node_2;
        LinkedListNode node_3 = new LinkedListNode("third");
        node_2.next = node_3;
        
	}
}