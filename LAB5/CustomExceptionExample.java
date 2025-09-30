Objective: Learn how to create and use a custom exception in Java.
Problem Statement

// Create a program that checks a student’s marks. If marks are negative or greater than 100, throw
// a custom exception InvalidMarksException.
import java.util.Scanner;
// Custom Exception class
class InvalidMarksException extends Exception {
public InvalidMarksException(String message) {
super(message);
}
}
public class CustomExceptionExample {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
System.out.print(&quot;Enter marks (0-100): &quot;);
int marks = sc.nextInt();
try {
if (marks &lt; 0 || marks &gt; 100) {
throw new InvalidMarksException(&quot;Marks should be between 0 and 100!&quot;);
} else {
System.out.println(&quot;Marks entered: &quot; + marks);
}
} catch (InvalidMarksException e) {
System.out.println(&quot;Error: &quot; + e.getMessage());
}
System.out.println(&quot;Program continues...&quot;);
sc.close();
}
}
