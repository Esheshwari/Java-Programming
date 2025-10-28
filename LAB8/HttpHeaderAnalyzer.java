// Lab 7: HTTP Header Analyzer using HttpURLConnection
// Write a program that:
// 1. Accepts a URL
// 2. Displays request method, response code, and message
// 3. Prints all HTTP headers

import java.io.*;
import java.net.*;
import java.util.*;

public class HttpHeaderAnalyzer {
    public static void main(String[] args) {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter URL (e.g., https://www.example.com): ");
            String urlStr = input.readLine();

            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            System.out.println("\n--- HTTP Info ---");
            System.out.println("Request Method: " + conn.getRequestMethod());
            System.out.println("Response Code: " + conn.getResponseCode());
            System.out.println("Response Message: " + conn.getResponseMessage());

            System.out.println("\n--- Headers ---");
            Map<String, List<String>> headers = conn.getHeaderFields();
            for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
                System.out.println((entry.getKey() != null ? entry.getKey() : "Status") + ": " + String.join(", ", entry.getValue()));
            }

            conn.disconnect();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
