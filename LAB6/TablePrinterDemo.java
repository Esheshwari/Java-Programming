// 2. Table Printer
// Write a program where two threads try to print the multiplication table of a number (say 5). Without
// synchronization, outputs may mix. Add synchronized so that one thread completes the full table
// before the other starts.
class TablePrinter {
    // Synchronized method to ensure one thread prints the full table before the other
    public synchronized void printTable(int number, String threadName) {
        System.out.println(threadName + " is printing the table of " + number);
        for (int i = 1; i <= 10; i++) {
            System.out.println(threadName + ": " + number + " x " + i + " = " + (number * i));
            try {
                Thread.sleep(100); // Simulate delay
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        }
        System.out.println(threadName + " finished printing.\n");
    }
}

class TableThread extends Thread {
    private TablePrinter printer;
    private String threadName;

    public TableThread(TablePrinter printer, String threadName) {
        this.printer = printer;
        this.threadName = threadName;
    }

    public void run() {
        printer.printTable(5, threadName);
    }
}

public class Main {
    public static void main(String[] args) {
        TablePrinter printer = new TablePrinter();

        TableThread t1 = new TableThread(printer, "Thread-A");
        TableThread t2 = new TableThread(printer, "Thread-B");

        t1.start();
        t2.start();
    }
}
