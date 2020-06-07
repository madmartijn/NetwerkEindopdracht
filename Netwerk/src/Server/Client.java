package Server;

import java.io.IOException;
import java.net.Socket;

public class Client {

    private String hostName;
    private int port;

    public static void main(String[] args) {
        Client client = new Client();
        client.connect();
    }

    public void connect () {

        try {
            Socket socket = new Socket(this.hostName, this.port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
