// Lab 4: WHOIS Lookup using Socket Programming
// Write a client program that:
// 1. Connects to whois.internic.net on port 43
// 2. Sends a domain name entered by the user
// 3. Displays WHOIS response

import java.io.*;
import java.net.*;

public class WhoisLookup {
    public static void main(String[] args) {
        try (Socket socket = new Socket("whois.internic.net", 43);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.print("Enter domain name: ");
            String domain = userInput.readLine();
            out.println(domain); // Send domain to WHOIS server

            System.out.println("\nWHOIS Response:");
            String line;
            while ((line = in.readLine()) != null)
                System.out.println(line);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
