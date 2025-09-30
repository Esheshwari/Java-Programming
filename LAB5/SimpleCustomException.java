// Objective: Check if a student’s age is valid (between 5 and 18). If not, throw a simple custom
// exception.
import java.util.Scanner;
// Step 1: Create a simple custom exception
class InvalidAgeException extends Exception {
public InvalidAgeException(String message) {

super(message);
}
}
public class SimpleCustomException {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
System.out.print(&quot;Enter student age: &quot;);
int age = sc.nextInt();
try {
// Step 2: Check condition and throw exception if invalid
if (age &lt; 5 || age &gt; 18) {
throw new InvalidAgeException(&quot;Age must be between 5 and 18!&quot;);
}
System.out.println(&quot;Valid age: &quot; + age);
} catch (InvalidAgeException e) {
System.out.println(&quot;Error: &quot; + e.getMessage());
}
System.out.println(&quot;Program continues...&quot;);
sc.close();
}
}
