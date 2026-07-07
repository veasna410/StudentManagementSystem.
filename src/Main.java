import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManagementSystem system = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(" 1. Add student");
            System.out.println(" 2. Delete student");
            System.out.println(" 3. Update student");
            System.out.println(" 4. Search student");
            System.out.println(" 5. Show student`s list");
            System.out.println(" 6. Exite");

            System.out.println(" \t Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println(" Enter name: ");
                    String name = scanner.nextLine();
                    system.add(name);
                    break;
                case 2:
                    System.out.println(" Enter id: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    system.delete(id);
                    break;
                case 3:
                    System.out.println(" Enter id: ");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter new name: ");
                    String newname = scanner.nextLine();
                    system.update(id, newname);
                    break;
                case 4:
                    System.out.println(" Enter name: ");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    system.search(id);
                    break;
                case 5:
                    system.show();
                    break;
                case 6:
                    System.out.println("Byee!");
                    return;
                default:
                    System.out.println("Invalid choice");


            }


        }
    }
}