// Lab 3: Find IP Address using InetAddress
// Write a program that:
// 1. Displays your computer’s IP address
// 2. Accepts a domain name (example: www.google.com)
// 3. Prints all IP addresses of that domain
import java.net.*;

public class FindIP {
    public static void main(String[] args) {
        try {
            // 1. Display local IP address
            InetAddress local = InetAddress.getLocalHost();
            System.out.println("Your IP: " + local.getHostAddress());

            // 2. Accept domain name
            String domain = "www.google.com"; // You can replace this or use Scanner for input

            // 3. Print all IPs of the domain
            InetAddress[] addresses = InetAddress.getAllByName(domain);
            System.out.println("IP addresses of " + domain + ":");
            for (InetAddress addr : addresses)
                System.out.println(addr.getHostAddress());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
