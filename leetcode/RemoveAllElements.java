import java.util.*;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

public class RemoveAllElements {
  public ListNode removeElements(ListNode head, int val) {
  	if (head == null) {
  		return head;
  	}
		while (head != null && head.val == val) {
			head = head.next;
		}
  	ListNode n = head;
  	while (n != null && n.next != null) {
  		if (n.next.val == val) {
  			while (n.next != null && n.next.val == val) {
  				n.next = n.next.next;
  			}
  		}
  		n = n.next;
  	}

  	return head;
  }

  public static void printListNodes(ListNode head) {
  	while (head != null) {
  		System.out.println(head.val);
  		head = head.next;
  	}
  }

  public static void main(String[] args) {
  	ListNode temp = new ListNode(1);
  	ListNode head = temp;
  	
  	for (int i = 2; i < 6; ++i) {
  		ListNode x = new ListNode(i);
  		temp.next = x;
  		temp = x;
  	}

  	ListNode head2 = null;

  	RemoveAllElements s = new RemoveAllElements();
  	head = s.removeElements(head, 1);
  	printListNodes(head);

  	head2 = s.removeElements(head2, 0);
  	printListNodes(head2);

  	return;
  }
}