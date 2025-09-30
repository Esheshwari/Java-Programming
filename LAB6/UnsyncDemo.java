// Problem Statement: We want two threads to print numbers from 1 to 5. - Case 1 (Unsynchronized):
// The outputs may interleave and look jumbled. - Case 2 (Synchronized): Each thread completes its
// full sequence before the other thread starts.
class Printer {
// not synchronized
void printNumbers(String threadName) {
for (int i = 1; i <= 5; i++) {
System.out.println(threadName + " prints: " + i);
try {
Thread.sleep(500); // slow down for visibility
} catch (InterruptedException e) {
e.printStackTrace();
}
}
}
}
class MyThread extends Thread {
Printer printer;
String threadName;
MyThread(Printer p, String name) {
printer = p;
threadName = name;
}
public void run() {
printer.printNumbers(threadName);
}
}
public class UnsyncDemo {
public static void main(String[] args) {
Printer p = new Printer();
MyThread t1 = new MyThread(p, "Thread-1");
MyThread t2 = new MyThread(p, "Thread-2");
t1.start();
t2.start();
}
}
