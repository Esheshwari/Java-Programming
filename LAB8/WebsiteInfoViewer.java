// Lab 6: Website Information Viewer using URLConnection
// Enter a URL and display:
// 1. Protocol
// 2. Content type
// 3. Date info (if available)
// 4. Content length (if available)
// Also show first few lines of webpage content

import java.io.*;
import java.net.*;

public class WebsiteInfoViewer {
    public static void main(String[] args) {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter URL (e.g., https://www.example.com): ");
            String urlStr = input.readLine();

            URL url = new URL(urlStr);
            URLConnection conn = url.openConnection();

            System.out.println("\n--- Website Info ---");
            System.out.println("Protocol: " + url.getProtocol());
            System.out.println("Content Type: " + conn.getContentType());
            System.out.println("Date: " + conn.getDate());
            System.out.println("Content Length: " + conn.getContentLength());

            System.out.println("\n--- Page Content (first few lines) ---");
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            for (int i = 0; i < 5; i++) {
                String line = reader.readLine();
                if (line == null) break;
                System.out.println(line);
            }

            reader.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
