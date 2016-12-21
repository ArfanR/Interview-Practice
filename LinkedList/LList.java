import java.util.*;

class LinkedListNode {

    public Object data;
   	public LinkedListNode next;

   	public LinkedListNode() {}

   	public void setVal(Object data) {
   		this.data = data;
   	}

   	public void setNext(LinkedListNode next) {
   		this.next = next;
   	}
}

public class LList {

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

	// Partition nodes into two linked lists
	LinkedListNode partition(LinkedListNode node, int x) {
		LinkedListNode head = node;
		LinkedListNode tail = node;

		while (node != null) {
			LinkedListNode next = node.next;
			if (node.data < x) {
				node.next = head;
				head = node;
			}
			else {
				tail.next = node;
				tail = node;
			}
			node = next;
		}
		tail.next = null;

		return head;
	}


	// Sum of two linked lists in reverse order
	// Recursive solution
	LinkedListNode sumLists(LinkedListNode node1, LinkedListNode node2, int rem) {
		if (node1 == null && node2 == null && rem == 0) {
			return null;
		}

		int val = 0;
		if (node1 != null) {
			val += node1.data;
		}
		if (node2 != null) {
			val += node2.data;
		}
		val = val % 10;

		LinkedListNode result = new LinkedListNode();
		result.setVal(val);
		// tail recursion
		if (node1 != null || node2 != null) {
			LinkedListNode next = sumLists(node1 == null ? null : node1.next, node2 == null ? null : node2.next, val >= 10 ? 1 : 0);
			result.setNext(next);
		}

		return result;
	}

	class PartialSum {
		public LinkedListNode sum = null;
		public int carry = 0;
	}

	LinkedListNode sumListsForward(LinkedListNode node1, LinkedListNode node2, int rem) {
		int len1 = length(l1);
		int len2 = length(l2);

		// pad list with zeros
		if (len1 < len2) {
			node1 = padList(node1, len2-len1);
		}
		else {
			node2 = padList(node2, len1-len2);
		}

		// head recursion


	}

	PartialSum addListsHelper(LinkedListNode n1, LinkedListNode n2) {
		if (n1 == null && n2 == null) {
			return new PartialSum();
		}

		PartialSum sum = addListsHelper(n1.next, n2.next);
		int val = sum.carry + n1.data + n2.data;
		LinkedListNode fullResult = insertBefore(sum.sum, val % 10);
		sum.sum = fullResult;
		sum.carry = val / 10;

		return sum;

	}
	LinkedListNode padList(LinkedListNode l, int padding) {
		LinkedListNode head = l;
		for (int i = 0; i < padding; i++) {
			head = insertBefore(head, 0);
		}
		return head;
	}

	LinkedListNode insertBefore(LinkedListNode list, int data) {
		LinkedListNode node = new LinkedListNode(data);
		if (list != null) {
			node.next = list;
		}
		return node;
	}

	public static void main(String[] args) {
        
	}
}