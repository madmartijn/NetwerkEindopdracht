package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private int port;
    private ServerSocket serverSocket;

    public Server(int port) {
        this.port = port;
    }

    public void connect () {

        try {
            this.serverSocket = new ServerSocket(port);

            Socket player1 = this.serverSocket.accept();
            System.out.println("Player 1 connected via: " + player1.getInetAddress().getHostAddress());

            Socket player2 = this.serverSocket.accept();
            System.out.println("Player 2 connected via: " + player2.getInetAddress().getHostAddress());

            this.serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
