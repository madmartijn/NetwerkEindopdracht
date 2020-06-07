package Server;

import Server.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client implements Runnable{

    private Socket socket;
    private Server server;
    private DataOutputStream out;
    private DataInputStream in;
    private String name;

    public Client(Socket socket, Server server) {
        this.socket = socket;
        this.server = server;
    }

    @Override
    public void run() {
        try{
            this.in = new DataInputStream(this.socket.getInputStream());
            this.out = new DataOutputStream(this.socket.getOutputStream());

            out.writeUTF("Connect");

            this.name = in.readUTF();
            System.out.println(this.name + " joined the game");

            String message = "";
            while (!message.equals("stop")) {
                message = in.readUTF();
                out.writeUTF(message);
                System.out.println("Client send: " + message);
            }

            this.socket.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
