package Server;

import Window.Window;

import java.io.IOException;
import java.net.Socket;
import java.util.Timer;

public class Client {

    private String hostName = "localhost";
    private int port = 10000;
    private Window window = new Window();

    public static void main(String[] args) {
        Client client = new Client();
        client.connect();

    }

    public void connect () {

        try {
            Socket socket = new Socket(this.hostName, this.port);
            while (this.window.getStatus() != 3) {
                socket.getOutputStream().write(this.window.getStatus());
                System.out.println(this.window.getStatus());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
}
