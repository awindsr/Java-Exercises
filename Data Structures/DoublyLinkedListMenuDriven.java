import java.util.LinkedList;
import java.util.Scanner;

public class DoublyLinkedListMenuDriven {

    public static void main(String[] args) {
        LinkedList<Integer> dll = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Append (Insert at End)");
            System.out.println("2. Insert at Front");
            System.out.println("3. Insert at Position");
            System.out.println("4. Delete");
            System.out.println("5. Display");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the element to append: ");
                    int appendElement = scanner.nextInt();
                    dll.addLast(appendElement);
                    break;
                case 2:
                    System.out.print("Enter the element to insert at the front: ");
                    int frontElement = scanner.nextInt();
                    dll.addFirst(frontElement);
                    break;
                case 3:
                    System.out.print("Enter the element to insert: ");
                    int insertElement = scanner.nextInt();
                    System.out.print("Enter the position to insert at: ");
                    int insertPosition = scanner.nextInt();
                    if (insertPosition >= 0 && insertPosition <= dll.size()) {
                        dll.add(insertPosition, insertElement);
                    } else {
                        System.out.println("Invalid position. Element not inserted.");
                    }
                    break;
                case 4:
                    System.out.print("Enter the element to delete: ");
                    int deleteElement = scanner.nextInt();
                    if (dll.remove(Integer.valueOf(deleteElement))) {
                        System.out.println("Element " + deleteElement + " deleted.");
                    } else {
                        System.out.println("Element " + deleteElement + " not found. Deletion failed.");
                    }
                    break;
                case 5:
                    System.out.println("Doubly linked list contents:");
                    System.out.println(dll);
                    break;
                case 6:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }

        } while (choice != 6);
    }
}
