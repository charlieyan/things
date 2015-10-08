// http://codercareer.blogspot.com/2011/09/interview-question-no-1-binary-search.html
import java.util.*;

class BinaryTreeNode {
    int val;
    BinaryTreeNode left;
    BinaryTreeNode right;
    BinaryTreeNode(int x) { val = x; }
}

class DoublyLinkedListNode {
    int val;
    DoublyLinkedListNode prev;
    DoublyLinkedListNode next;
    DoublyLinkedListNode(int x) { val = x; }
}

public class BstToDll {

    public static DoublyLinkedListNode walkToMost(DoublyLinkedListNode start, int direction) {
        DoublyLinkedListNode temp = start;
        if (direction == 0) {
            while (temp.prev != null) {
                temp = temp.prev;
            }
        }
        else {
            while (temp.next != null) {
                temp = temp.next;
            }
        }
        return temp;
    }

    public static DoublyLinkedListNode rearrangeHelper(BinaryTreeNode root, int direction) {
        // in an in-order fashion
        // call rearrangeHelper on left
        // make a new node or root, and 
        // call rearrangeHelper on right
        if (root == null) {
            return null;
        }
        // System.out.println(root.val);
        DoublyLinkedListNode middle = new DoublyLinkedListNode(root.val);
        DoublyLinkedListNode leftMostRight = rearrangeHelper(root.left, 1); // give me the rightmost
        middle.prev = leftMostRight;
        if (leftMostRight != null) {
            leftMostRight.next = middle;
        }
        DoublyLinkedListNode rightMostLeft = rearrangeHelper(root.right, 0); // give me the leftmost
        middle.next = rightMostLeft;
        if (rightMostLeft != null) {
            rightMostLeft.prev = middle;
        }
        return walkToMost(middle, direction);
    }

    public static DoublyLinkedListNode rearrange(BinaryTreeNode root) {
        return rearrangeHelper(root, 0);
    }

    public static void printDLL(DoublyLinkedListNode start) {
        DoublyLinkedListNode temp = start;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        // set up the tree
        BinaryTreeNode root = new BinaryTreeNode(10);
        BinaryTreeNode left = new BinaryTreeNode(6);
        BinaryTreeNode right = new BinaryTreeNode(14);
        root.left = left;
        root.right = right;
        left.left = new BinaryTreeNode(4);
        left.right = new BinaryTreeNode(8);
        right.left = new BinaryTreeNode(12);
        right.right = new BinaryTreeNode(16);
        printDLL(rearrange(root));
    }
}