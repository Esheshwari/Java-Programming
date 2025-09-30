// //Exercise 3: Exam Marks Validation
// Problem:
// Write a program to enter marks for a subject (0-100). If the user enters marks outside this range,
// throw a custom exception called InvalidMarksException with a message &quot;Marks should be
// between 0 and 100.&quot;.
// Expected Behavior:
//  Input: 120 → Output: Error: Marks should be between 0 and 100.
//  Input: 85 → Output: Marks entered: 85

// Hints for All Exercises
// 1. Create a custom exception class that extends Exception.
// 2. Use throw to raise the exception when the condition fails.
// 3. Use try-catch to handle the exception gracefully.
import java.util.Scanner;

// Custom Exception Class
class InvalidMarksException extends Exception {
    public InvalidMarksException(String message) {
        super(message);
    }
}

public class MarksValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter marks (0-100): ");

        try {
            int marks = scanner.nextInt();

            if (marks < 0 || marks > 100) {
                throw new InvalidMarksException("Marks should be between 0 and 100.");
            }

            System.out.println("Marks entered: " + marks);
        } catch (InvalidMarksException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter numeric marks.");
        } finally {
            scanner.close();
        }
    }
}
