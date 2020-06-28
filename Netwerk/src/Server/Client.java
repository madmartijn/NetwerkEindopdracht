package Server;

import Board.Tile.Tile2;
import Server.Server;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client implements Runnable{

    private Socket socket;
    private Server server;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private String name;
    private Tile2[][] gameBoardIn;
    private Tile2[][] gameBoardOut;

    String host;
    int port;
    boolean connected;

    public Client(String host, int port){
        this.host = host;
        this.port = port;
        this.socket = null;
        this.connected = false;
        this.out = null;
    }

    public boolean connect(){
        if (this.connected){
            System.out.println("client already connected");
            return true;
        }

        try {
            this.socket = new Socket(this.host, this.port);
            this.connected = true;

            this.out = new ObjectOutputStream(this.socket.getOutputStream());
            this.in = new ObjectInputStream(this.socket.getInputStream());

            //this.gameBoardIn = (Tile2[][]) this.in.readObject();
            
            while (this.connected){

                this.gameBoardOut = new Tile2[16][8];
                this.out.writeObject(gameBoardOut);

                this.gameBoardIn = (Tile2[][]) this.in.readObject();
                System.out.println("Got response from server");

            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Could not connect to server" + e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        return false;
    }

    @Override
    public void run() {
        try {
            this.out.writeObject(this.gameBoardOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
