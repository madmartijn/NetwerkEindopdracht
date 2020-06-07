package Server;

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

    public boolean start () {
        try {
            this.server = new ServerSocket(port);

            this.serverThread = new Thread( () -> {
                while (true) {
                    System.out.println("Waiting for clients to connect");
                    try{
                        Socket socket = this.server.accept();
                        System.out.println("Client connected form " + socket.getInetAddress().getHostAddress() + ".");

                        Client client = new Client(socket, this);
                        Thread threadClient = new Thread(client);
                        threadClient.start();
                        this.clients.add(client);
                        this.threads.add(threadClient);

                        System.out.println("Total clients connected: " + this.clients.size());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            });

            this.serverThread.start();
            System.out.println("Server is started and listening on port " + this.port);
        } catch (IOException e) {
            System.out.println("Could not connect: " + e.getMessage());
            return false;
        }
        return true;
    }
}
