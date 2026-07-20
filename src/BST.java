public class BST {

    private Node root;

    public BST() {
        root = null;
    }

    public void insert(int value) {

        if (root == null) {
            root = new Node(value);
            return;
        }

        Node current = root;
        Node parent = null;

        while (current != null) {

            parent = current;

            if (value < current.value) {
                current = current.left;
            } else if (value > current.value) {
                current = current.right;
            } else {
                return;
            }

        }

        if (value < parent.value) {
            parent.left = new Node(value);
        } else {
            parent.right = new Node(value);
        }

    }

    public boolean search(int value) {

        Node current = root;

        while (current != null) {

            if (value == current.value) {
                return true;
            }

            if (value < current.value) {
                current = current.left;
            } else {
                current = current.right;
            }

        }

        return false;

    }

    public int findMin() {

        if (root == null) {
            throw new IllegalStateException("Tree is empty.");
        }

        Node current = root;

        while (current.left != null) {
            current = current.left;
        }

        return current.value;

    }

    public int findMax() {

        if (root == null) {
            throw new IllegalStateException("Tree is empty.");
        }

        Node current = root;

        while (current.right != null) {
            current = current.right;
        }

        return current.value;

    }

    public void inorder() {
        inorder(root);
        System.out.println();
    }

    private void inorder(Node node) {

        if (node != null) {

            inorder(node.left);

            System.out.print(node.value + " ");

            inorder(node.right);

        }

    }

    public void preorder() {
        preorder(root);
        System.out.println();
    }

    private void preorder(Node node) {

        if (node != null) {

            System.out.print(node.value + "");

            preorder(node.left);

            preorder(node.right);

        }

    }

    public void postorder() {
        postorder(root);
        System.out.println();
    }

    private void postorder(Node node) {

        if (node != null) {

            postorder(node.left);

            postorder(node.right);

            System.out.print(node.value + " ");

        }

    }

}