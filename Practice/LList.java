import java.util.*;

public class LList {

	// reverse a linked list
	public static void reverse(LinkedListNode head) {
		LinkedListNode prev = null;
		LinkedListNode current = head;
		LinkedListNode next;

		while (current != null) {
			next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
		}

		head = prev;
	}

	// detect if linked list is cyclic
	public static boolean isCyclic(LinkedListNode head) {
		LinkedListNode slow = head;
		LinkedListNode fast = head.next;

		while (true) {
			if (fast.next == null || fast == null) {
				return false;
			}
			else if (fast == slow || fast.next == slow) {
				return true;
			}
			else {
				slow = slow.next;
				fast = fast.next.next;
			}
		}
	}

	// Use hash set to check for duplicates
	public static LinkedListNode deleteDups(LinkedListNode n) {
		if (n == null) return null;

	    LinkedListNode temp = n;
	    LinkedListNode next;

	    while (temp.next != null) {
	        if (temp.val == temp.next.val) {
	            next = temp.next.next;
	            temp.next = null;
	            temp.next = next;
	        }
	        else {
	            temp = temp.next;
	        }
	    }

	    return n;
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
	// Example of tail recursion: do work on the way down, then recurse
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

	// sum of two linked lists in forward order
	// PartialSum wrapper class
	class PartialSum {
		public LinkedListNode sum = null;
		public int carry = 0;
	}

	LinkedListNode sumListsForward(LinkedListNode node1, LinkedListNode node2) {
		int len1 = length(l1);
		int len2 = length(l2);

		// pad list with zeros
		if (len1 < len2) {
			node1 = padList(node1, len2-len1);
		}
		else {
			node2 = padList(node2, len1-len2);
		}

		if (n1 == null && n2 == null) {
			return new PartialSum();
		}

		// head recursion
		PartialSum sum = sumListsForward(n1.next, n2.next);
		int val = sum.carry + n1.data + n2.data;
		LinkedListNode fullResult = insertBefore(sum.sum, val % 10);
		sum.sum = fullResult;
		sum.carry = val / 10;
		return sum;

		if (sum.carry == 0) {
			return sum.sum;
		}
		else {
			LinkedListNode result = insertBefore(sum.sum, sum.carry);
			return result;
		}

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

	// check if llist is palindrome using stack
	public static boolean isPalindrome(LinkedListNode head) {
		LinkedListNode slow = head;
		LinkedListNode fast = head;

		Stack<Integer> stack = new Stack<Integer>();
		while (fast != null && fast.next != null) {
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}

		if (fast != null) {
			slow = slow.next;
		}

		while (slow != null) {
			int top = stack.pop();
			if (top != slow.data) {
				return false;
			}
			slow = slow.next;
		}
		return true;

	}

	class Result {
		public LinkedListNode tail;
		public int size;
		public Result(LinkedListNode tail, int size) {
			this.tail = tail;
			this.size = size;
		}
	}

	public Result getResult(LinkedListNode node) {
		int length = 1;
		LinkedListNode temp = node;

		while (temp.next != null) {
			length++;
			temp = temp.next;
		}

		return new Result(temp, length);
	}

	// check for intersection between two linked lists
	LinkedListNode intersection(LinkedListNode node1, LinkedListNode node2) {
		LinkedListNode result = null;

		Result listA = getResult(node1);
		Result listB = getResult(node2);

		if (listA.tail == listB.tail) {
			int diff = 0;
			if (listA.size > listB.size) {
				diff = listA.size - listB.size;
			}
			else if (listA.size < listB.size) {
				diff = listB.size - listA.size;
			}

			while (node1 != node2) {
				if (listA.size > listB.size) {
					node2 = node2.next;
					for (int i = 0; i < diff; i++) { node1 = node1.next; };
				}
				else if (listA.size < listB.size) {
					node1 = node1.next;
					for (int i = 0; i < diff; i++) { node2 = node2.next; };
				}
				else {
					node1 = node1.next;
					node2 = node2.next;
				}
			}
			result = node1;
		}

		return result;
	}

	// return node where there is a cycle
	public static LinkedListNode findCycle(LinkedListNode head) {
		LinkedListNode cycle;
		LinkedListNode slow = head;
		LinkedListNode fast = head.next;

		while (true) {
			if (fast.next == null || fast == null) {
				return null;
			}
			else if (fast == slow || fast.next == slow) {
				break;
			}
			else {
				slow = slow.next;
				fast = fast.next.next;
			}
		}

		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}

		return slow;

	}

}