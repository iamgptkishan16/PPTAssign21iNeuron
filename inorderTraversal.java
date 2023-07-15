/*
💡 Question-1

You are given a binary tree. The binary tree is represented using the TreeNode class. Each TreeNode has an integer value and left and right children, represented using the TreeNode class itself. Convert this binary tree into a binary search tree.

Input:

        10

       /   \

     2      7

   /   \

 8      4

Output:

        8

      /   \

    4     10

  /   \

2      7

*/

package Java_DSA.Trees.Assignment21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

class inorderTraversal {
    private static List<Integer> values;

    public static TreeNode convertBinaryTreeToBST(TreeNode root) {
        if (root == null) {
            return null;
        }

        values = new ArrayList<>();
        inorderTraversal1(root);
        Collections.sort(values);

        return constructBST(0, values.size() - 1);
    }

    private static void inorderTraversal1(TreeNode node) {
        if (node == null) {
            return;
        }

        inorderTraversal1(node.left);
        values.add(node.val);
        inorderTraversal2(node.right);
    }

    private static TreeNode constructBST(int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(values.get(mid));

        node.left = constructBST(start, mid - 1);
        node.right = constructBST(mid + 1, end);

        return node;
    }

    public static void inorderTraversal2(TreeNode root) {
        if (root == null) {
            return;
        }

        inorderTraversal1(root.left);
        System.out.print(root.val + " ");
        inorderTraversal2(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(4);

        System.out.println("Original Binary Tree:");
        inorderTraversal1(root);

        TreeNode bstRoot = convertBinaryTreeToBST(root);

        System.out.println("\n\nConverted Binary Search Tree:");
        inorderTraversal2(bstRoot);
    }
}
