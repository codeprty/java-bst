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
            } 
            else if (value > current.value) {
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

            System.out.print(node.value + " ");

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

    public int countNodes() {
        return countNodes(root);
    }

    private int countNodes(Node node) {

        if (node == null) {
            return 0;
        }

        return countNodes(node.left)
                + countNodes(node.right)
                + 1;

    }

    public int countLeafNodes() {
        return countLeafNodes(root);
    }

    private int countLeafNodes(Node node) {

        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null) {
            return 1;
        }

        return countLeafNodes(node.left)
                + countLeafNodes(node.right);

    }

    public int height() {
        return height(root);
    }

    private int height(Node node) {

        if (node == null) {
            return 0;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        return Math.max(leftHeight, rightHeight) + 1;

    }

    public void delete(int value) {

        Node current = root;
        Node parent = null;

        while (current != null && current.value != value) {

            parent = current;

            if (value < current.value) {
                current = current.left;
            } else {
                current = current.right;
            }

        }

        if (current == null) {
            System.out.println("Value not found.");
            return;
        }

        if (current.left == null && current.right == null) {

            if (current == root) {
                root = null;
            } else if (parent.left == current) {
                parent.left = null;
            } else {
                parent.right = null;
            }

            return;

        }

        if (current.left == null || current.right == null) {

            Node child;

            if (current.left != null) {
                child = current.left;
            } else {
                child = current.right;
            }

            if (current == root) {
                root = child;
            } else if (parent.left == current) {
                parent.left = child;
            } else {
                parent.right = child;
            }

            return;

        }

        Node successorParent = current;
        Node successor = current.right;

        while (successor.left != null) {
            successorParent = successor;
            successor = successor.left;
        }

        current.value = successor.value;

        if (successorParent.left == successor) {
            successorParent.left = successor.right;
        } else {
            successorParent.right = successor.right;
        }

    }

}