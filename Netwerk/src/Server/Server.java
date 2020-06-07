package Server;

import Board.Tile.Tile2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

    private int port;
    private ServerSocket server;
    String host;
    private Thread serverThread;
    private ArrayList<Client> clients;
    private ArrayList<Thread> threads;
    boolean running;

    public Server(String host, int port) {
        this.host = host;
        this.port = port;
        this.clients = new ArrayList<>();
        this.threads = new ArrayList<>();

        this.running = false;
        this.server = null;

    }

    public void start () throws IOException {
        if (this.server !=  null){
            System.out.println("Server already running");
            return;
        }


        try {
            this.server = new ServerSocket(this.port);
            this.running = true;
        } catch (IOException e) {
            throw e;
        }


        while (this.running){
            System.out.println("Awaiting connection");
            Socket client = this.server.accept();
            new Thread( () -> {
                handeClientConnectionObject(client);
                System.out.println("Client connected");
            }).start();
        }


        System.out.println("Server is started and listening on port " + this.port);


//        return true;
    }

    public boolean isRunning() {
        return running;
    }

    private void handleClientConnection(Socket client){

        try {
            ObjectInputStream in = new ObjectInputStream(client.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());

            boolean connected = true;

            out.writeUTF("It me, server");
            while (connected){
                Tile2[][] gameBoard;

            }
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handeClientConnectionObject(Socket client){
        System.out.println("OBJECT");
        try {
            ObjectInputStream in = new ObjectInputStream(client.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());

            boolean connected = true;

            out.writeObject(new String("Connected"));

            while (connected){
                Tile2[][] gameBoard = (Tile2[][]) in.readObject();
                out.writeObject(gameBoard);

            }
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
