import java.net.*;
import java.io.*;

public class server {
    ServerSocket server;
    Socket socket;

    BufferedReader br;  // To read from client
    PrintWriter out;    // To send to client
    //Declare Components
    

    public server() {
        try {
            server = new ServerSocket(7776);
            System.out.println("Server is ready to accept connection");
            System.out.println("Waiting...");
            socket = server.accept();

            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream());

            startReading();
            startWriting();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Reading thread - reads messages from the client
    public void startReading() {
        Runnable r1 = () -> {
            System.out.println("Reader started...");
            try {
                while (true) {
                    String msg = br.readLine();
                    if (msg == null || msg.equalsIgnoreCase("exit")) {
                        System.out.println("Client terminated the chat.");

                        socket.close(); 
                        break;
                    }
                    System.out.println("Client: " + msg);
                }
            } catch (IOException e) {
                System.out.println("Connection closed.");
            }
        };
        new Thread(r1).start();
    }

    // Writing thread - sends messages to the client
    public void startWriting() {
        Runnable r2 = () -> {
            System.out.println("Writer started...");
            try {
                BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
                while (true) {
                    String content = br1.readLine();
                    out.println(content);
                    out.flush();

                    if(content.equals("exist")){ //check
                        socket.close();
                        break;
                    }
                }
            } catch (IOException e) {
                System.out.println("Connection closed.");
            }
        };
        new Thread(r2).start();  // <-- You were missing this!
    }

    public static void main(String[] args) {
        System.out.println("This is the server. Starting up...");
        new server();
    }
}
