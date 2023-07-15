/*
💡 Question-2:

Given a Binary Search Tree with all unique values and two keys. Find the distance between two nodes in BST. The given keys always exist in BST.

Example:

Consider the following BST:

![1.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/f2455039-7e12-43fc-a7d3-b5be24931c1c/1.png)

**Input-1:**

n = 9

values = [8, 3, 1, 6, 4, 7, 10, 14,13]

node-1 = 6

node-2 = 14

**Output-1:**

The distance between the two keys = 4

**Input-2:**

n = 9

values = [8, 3, 1, 6, 4, 7, 10, 14,13]

node-1 = 3

node-2 = 4

**Output-2:**

The distance between the two keys = 2

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

class BSTDistance {
    public static int findDistance(TreeNode root, int node1, int node2) {
        TreeNode lca = findLCA(root, node1, node2);
        int distance1 = findDistanceToNode(lca, node1, 0);
        int distance2 = findDistanceToNode(lca, node2, 0);
        return distance1 + distance2;
    }

    private static TreeNode findLCA(TreeNode root, int node1, int node2) {
        if (root == null) {
            return null;
        }

        if (root.val > node1 && root.val > node2) {
            return findLCA(root.left, node1, node2);
        } else if (root.val < node1 && root.val < node2) {
            return findLCA(root.right, node1, node2);
        } else {
            return root;
        }
    }

    private static int findDistanceToNode(TreeNode root, int target, int distance) {
        if (root == null) {
            return -1;
        }

        if (root.val == target) {
            return distance;
        } else if (root.val > target) {
            return findDistanceToNode(root.left, target, distance + 1);
        } else {
            return findDistanceToNode(root.right, target, distance + 1);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        int node1 = 2;
        int node2 = 5;

        int distance = findDistance(root, node1, node2);
        System.out.println("Distance between " + node1 + " and " + node2 + " in BST: " + distance);
    }
}
