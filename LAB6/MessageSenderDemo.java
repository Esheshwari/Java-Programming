// 3. Message Sender
// Create a MessageSender class with a method sendMessage(String msg) that prints a message
// with a small delay. Run two threads trying to send messages at the same time. Use synchronization
// so that full messages are printed clearly without mixing.
class MessageSender {
    // Synchronized method to prevent message mixing
    public synchronized void sendMessage(String msg, String senderName) {
        System.out.println(senderName + " is sending a message...");
        try {
            Thread.sleep(100); // Simulate delay
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println(senderName + ": " + msg);
        System.out.println(senderName + " finished sending.\n");
    }
}

class SenderThread extends Thread {
    private MessageSender sender;
    private String message;
    private String senderName;

    public SenderThread(MessageSender sender, String message, String senderName) {
        this.sender = sender;
        this.message = message;
        this.senderName = senderName;
    }

    public void run() {
        sender.sendMessage(message, senderName);
    }
}

public class MessageSenderDemo {
    public static void main(String[] args) {
        MessageSender sender = new MessageSender();

        SenderThread t1 = new SenderThread(sender, "Hello from Alice!", "Alice");
        SenderThread t2 = new SenderThread(sender, "Greetings from Bob!", "Bob");

        t1.start();
        t2.start();
    }
}
