import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        BST tree = new BST();

        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(70);

        int choice;

        do {
            
            System.out.println("\n===== Binary Search Tree =====");
            System.out.println("1. Insert Value");
            System.out.println("2. Delete Value");
            System.out.println("3. Search Value");
            System.out.println("4. Find Minimum");
            System.out.println("5. Find Maximum");
            System.out.println("6. Display Traversals");
            System.out.println("7. Display Tree Properties");
            System.out.println("8. Exit");

            System.out.print("\nEnter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter value to insert: ");
                    int insertValue = scanner.nextInt();

                    tree.insert(insertValue);

                    System.out.println("Value inserted successfully.");

                    break;

                case 2:

                    System.out.print("Enter value to delete: ");
                    int deleteValue = scanner.nextInt();

                    tree.delete(deleteValue);

                    break;

                case 3:

                    System.out.print("Enter value to search: ");
                    int searchValue = scanner.nextInt();

                    if (tree.search(searchValue)) {
                        System.out.println("Value found.");
                    } else {
                        System.out.println("Value not found.");
                    }

                    break;

                case 4:

                    try {
                        System.out.println("Minimum Value: " + tree.findMin());
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }

                    break;

                case 5:

                    try {
                        System.out.println("Maximum Value: " + tree.findMax());
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }

                    break;

                case 6:

                    System.out.println("\nInorder Traversal:");
                    tree.inorder();

                    System.out.println("\nPreorder Traversal:");
                    tree.preorder();

                    System.out.println("\nPostorder Traversal:");
                    tree.postorder();

                    break;

                case 7:

                    System.out.println("\nTree Properties");
                    System.out.println("Height: " + tree.height());
                    System.out.println("Total Nodes: " + tree.countNodes());
                    System.out.println("Leaf Nodes: " + tree.countLeafNodes());

                    break;

                case 8:

                    System.out.println("Program terminated.");

                    break;

                default:

                    System.out.println("Invalid choice.");

                    break;

            }

        } while (choice != 6);

        scanner.close();

    }

}