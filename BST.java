
class BST {

    public class Node {

        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    // public void insert(int value) {
    //     root = insert(value, root);
    // }
    private Node insert(int value, Node node) {
        if (node == null) {
            node = new Node(value);
            return node;
        }

        if (value < node.value) {
            node.left = insert(value, node.left);
        }

        if (value > node.value) {
            node.right = insert(value, node.right);
        }

        return node;
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }

    public class Main {

        public static void main(String[] args) {

            BST tree = new BST();
            int[] nums = {5, 2, 7, 1, 4, 6, 9, 8, 3, 10};
            Node root = null;
            for (int i = 0; i < nums.length; i++) {
                root = tree.insert(nums[i], root);
            }
            tree.inOrder(root);

        }
    }

}
