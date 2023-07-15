/*
💡 Question-4:

Write a program to connect nodes at the same level.

Input:

        1

      /   \

    2      3

  /   \   /   \

4     5 6    7

Output:

1 → -1

2 → 3

3 → -1

4 → 5

5 → 6

6 → 7

7 → -1

*/

package Java_DSA.Trees.Assignment21;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int val;
    Node left;
    Node right;
    Node nextRight;

    Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
        this.nextRight = null;
    }
}

class ConnectNodesAtSameLevel {
    public static void connectNodes(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            Node prev = null;

            for (int i = 0; i < size; i++) {
                Node current = queue.poll();

                // Connect current node to the right node
                if (prev != null) {
                    prev.nextRight = current;
                }

                prev = current;

                if (current.left != null) {
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
        }
    }

    public static void printConnectedNodes(Node root) {
        Node currentLevel = root;
        while (currentLevel != null) {
            Node current = currentLevel;
            while (current != null) {
                System.out.print(current.val + " ");
                current = current.nextRight;
            }
            System.out.println();
            currentLevel = currentLevel.left;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        connectNodes(root);
        System.out.println("Connected nodes at the same level:");
        printConnectedNodes(root);
    }
}
