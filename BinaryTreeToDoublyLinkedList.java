/*
💡 Question-3:

Write a program to convert a binary tree to a doubly linked list.

Input:

        10

       /   \

     5     20

           /   \

        30     35

Output:

5 10 30 20 35

*/

package Java_DSA.Trees.Assignment21;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class DoublyLinkedListNode {
    int val;
    DoublyLinkedListNode prev;
    DoublyLinkedListNode next;

    DoublyLinkedListNode(int val) {
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class BinaryTreeToDoublyLinkedList {
    private static DoublyLinkedListNode prev;

    public static DoublyLinkedListNode convertBinaryTreeToDoublyLinkedList(TreeNode root) {
        if (root == null) {
            return null;
        }

        DoublyLinkedListNode dummy = new DoublyLinkedListNode(0);
        prev = dummy;

        convertHelper(root);

        DoublyLinkedListNode head = dummy.next;
        if (head != null) {
            head.prev = null;
        }

        return head;
    }

    private static void convertHelper(TreeNode node) {
        if (node == null) {
            return;
        }

        convertHelper(node.left);

        DoublyLinkedListNode curr = new DoublyLinkedListNode(node.val);
        prev.next = curr;
        curr.prev = prev;
        prev = curr;

        convertHelper(node.right);
    }

    public static void printDoublyLinkedList(DoublyLinkedListNode head) {
        if (head == null) {
            return;
        }

        DoublyLinkedListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        DoublyLinkedListNode head = convertBinaryTreeToDoublyLinkedList(root);
        System.out.println("Doubly Linked List:");
        printDoublyLinkedList(head);
    }
}
