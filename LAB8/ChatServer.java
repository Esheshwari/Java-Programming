// Lab 5: Simple Client-Server Chat Application
// Develop two programs:
// 1. Server waits for a client and prints received messages
// 2. Client sends text typed by user
// Test by running the server first

import java.io.*;
import java.net.*;

public class ChatServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(1234);
        System.out.println("Server started. Waiting for client...");
        Socket socket = server.accept();
        System.out.println("Client connected.");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String msg;
        while ((msg = in.readLine()) != null) {
            System.out.println("Client: " + msg);
        }

        socket.close();
        server.close();
    }
}
