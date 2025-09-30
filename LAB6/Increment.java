// 5. Counter Increment
// Create a Counter class with a variable count = 0. Start two threads that each increment the counter
// 1000 times. Without synchronization, the final count may be less than 2000. Use synchronized to
// ensure correctness.
class Counter {
    private int count = 0;

    // Synchronized method to ensure atomic increments
    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

class CounterThread extends Thread {
    private Counter counter;

    public CounterThread(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}

public class Increment {
    public static void main(String[] args) {
        Counter counter = new Counter();

        CounterThread t1 = new CounterThread(counter);
        CounterThread t2 = new CounterThread(counter);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }

        System.out.println("Final count: " + counter.getCount());
    }
}
