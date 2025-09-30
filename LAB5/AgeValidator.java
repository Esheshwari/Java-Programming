// Exercise 2: Password Strength Check
// Problem:
// Create a program that asks the user to enter a password. If the password length is less than 6
// characters, throw a custom exception called WeakPasswordException with a message
// &quot;Password too short! Must be at least 6 characters.&quot;.
// Expected Behavior:
//  Input: &quot;abc&quot; → Output: Error: Password too short! Must be at least 6
// characters.
//  Input: &quot;abcdef&quot; → Output: Password accepted.
import java.util.Scanner;

// Custom Exception Class
class UnderAgeException extends Exception {
    public UnderAgeException(String message) {
        super(message);
    }
}

public class AgeValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your age: ");

        try {
            int age = scanner.nextInt();

            if (age < 18) {
                throw new UnderAgeException("You must be at least 18 years old!");
            }

            System.out.println("Valid age: " + age);
        } catch (UnderAgeException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid number.");
        } finally {
            scanner.close();
        }
    }
}
