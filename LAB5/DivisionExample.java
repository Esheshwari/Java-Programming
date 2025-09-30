// Write a Java program that divides two numbers. If the divisor is zero, the program should catch
// the exception and display a friendly message.
import java.util.Scanner;
public class DivisionExample {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
System.out.print(&quot;Enter numerator: &quot;);
int numerator = sc.nextInt();
System.out.print(&quot;Enter denominator: &quot;);
int denominator = sc.nextInt();
try {
int result = numerator / denominator;
System.out.println(&quot;Result: &quot; + result);
} catch (ArithmeticException e) {
System.out.println(&quot;Error: Cannot divide by zero!&quot;);
}
System.out.println(&quot;Program continues...&quot;);
sc.close();
}
}
