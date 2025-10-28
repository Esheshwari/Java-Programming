//another half of chatserver program

import java.io.*;
import java.net.*;

public class ChatClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 1234);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

        String msg;
        System.out.println("Connected to server. Type messages:");
        while ((msg = userInput.readLine()) != null) {
            out.println(msg);
        }

        socket.close();
    }
}
