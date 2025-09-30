// 4. Ticket Booking System
// Simulate a ticket booking system with 5 tickets available. Create multiple threads representing
// users trying to book tickets. Use synchronized so that two users cannot book the same ticket.
class TicketBooking {
    private int ticketsAvailable = 5;

    // Synchronized method to prevent double booking
    public synchronized void bookTicket(String userName) {
        if (ticketsAvailable > 0) {
            System.out.println(userName + " is booking a ticket...");
            try {
                Thread.sleep(100); // Simulate processing delay
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
            ticketsAvailable--;
            System.out.println(userName + " successfully booked a ticket.");
        } else {
            System.out.println(userName + " tried to book a ticket but none are available.");
        }
        System.out.println("Tickets remaining: " + ticketsAvailable + "\n");
    }
}

class UserThread extends Thread {
    private TicketBooking bookingSystem;
    private String userName;

    public UserThread(TicketBooking bookingSystem, String userName) {
        this.bookingSystem = bookingSystem;
        this.userName = userName;
    }

    public void run() {
        bookingSystem.bookTicket(userName);
    }
}

public class Ticket {
    public static void main(String[] args) {
        TicketBooking bookingSystem = new TicketBooking();

        // Simulate 7 users trying to book 5 tickets
        for (int i = 1; i <= 7; i++) {
            UserThread user = new UserThread(bookingSystem, "User-" + i);
            user.start();
        }
    }
}
