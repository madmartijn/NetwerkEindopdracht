import Server.Server;

import java.io.IOException;

public class Server_ {

    public static void main(String[] args) {

        Server server = new Server("localhost", 10000);

        try {
            server.start();

        } catch (IOException e) {
            System.out.println("Could not start server" + e.getMessage());
        }

    }

}
