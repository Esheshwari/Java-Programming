// Lab 1: Student List using ArrayList
// Create a Java program to manage a list of students using ArrayList. The program must allow:
// 1. Adding student records
// 2. Inserting a student at a specific index
// 3. Updating a student’s name
// 4. Removing a student by name or index
// 5. Displaying the list after every action
import java.util.ArrayList;
import java.util.Scanner;

public class StudentListManager {
    public static void main(String[] args) {
        ArrayList<String> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Student List Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. Insert Student at Index");
            System.out.println("3. Update Student Name");
            System.out.println("4. Remove Student (by name or index)");
            System.out.println("5. Display Student List");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter student name to add: ");
                    String nameToAdd = scanner.nextLine();
                    students.add(nameToAdd);
                    System.out.println("Student added.");
                    break;

                case 2:
                    System.out.print("Enter student name to insert: ");
                    String nameToInsert = scanner.nextLine();
                    System.out.print("Enter index to insert at: ");
                    int indexToInsert = scanner.nextInt();
                    scanner.nextLine();
                    if (indexToInsert >= 0 && indexToInsert <= students.size()) {
                        students.add(indexToInsert, nameToInsert);
                        System.out.println("Student inserted.");
                    } else {
                        System.out.println("Invalid index.");
                    }
                    break;

                case 3:
                    System.out.print("Enter index of student to update: ");
                    int indexToUpdate = scanner.nextInt();
                    scanner.nextLine();
                    if (indexToUpdate >= 0 && indexToUpdate < students.size()) {
                        System.out.print("Enter new name: ");
                        String newName = scanner.nextLine();
                        students.set(indexToUpdate, newName);
                        System.out.println("Student name updated.");
                    } else {
                        System.out.println("Invalid index.");
                    }
                    break;

                case 4:
                    System.out.println("Remove by:");
                    System.out.println("1. Name");
                    System.out.println("2. Index");
                    int removeChoice = scanner.nextInt();
                    scanner.nextLine();
                    if (removeChoice == 1) {
                        System.out.print("Enter name to remove: ");
                        String nameToRemove = scanner.nextLine();
                        if (students.remove(nameToRemove)) {
                            System.out.println("Student removed.");
                        } else {
                            System.out.println("Student not found.");
                        }
                    } else if (removeChoice == 2) {
                        System.out.print("Enter index to remove: ");
                        int indexToRemove = scanner.nextInt();
                        scanner.nextLine();
                        if (indexToRemove >= 0 && indexToRemove < students.size()) {
                            students.remove(indexToRemove);
                            System.out.println("Student removed.");
                        } else {
                            System.out.println("Invalid index.");
                        }
                    } else {
                        System.out.println("Invalid choice.");
                    }
                    break;

                case 5:
                    System.out.println("\nCurrent Student List:");
                    for (int i = 0; i < students.size(); i++) {
                        System.out.println(i + ": " + students.get(i));
                    }
                    break;

                case 0:
                    System.out.println("Exiting program.");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}
