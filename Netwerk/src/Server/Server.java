package Server;

import Window.Window;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

    private int port;
    private ServerSocket server;
    private Thread serverThread;
    private ArrayList<Client> clients;
    private ArrayList<Thread> threads;

    public Server(int port) {
        this.port = port;
        this.clients = new ArrayList<>();
        this.threads = new ArrayList<>();
    }

    public void start () {
        new Thread( () -> {
        try {
            // Create a server socket
            ServerSocket serverSocket = new ServerSocket(8000);

            while (true) {

                Socket player1 = serverSocket.accept();

                // Notify that the player is Player 1
                new DataOutputStream(
                        player1.getOutputStream()).writeUTF("Player 1 connected");

                // Connect to player 2
                Socket player2 = serverSocket.accept();

                // Notify that the player is Player 2
                new DataOutputStream(
                        player2.getOutputStream()).writeUTF("Player 2 connected");

                new Thread(new Window(player1, player2)).start();
            }
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
    }).start();
    }
}
