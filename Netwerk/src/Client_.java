import Server.Server;
import Server.Client;

public class Client_ {

    public static void main(String[] args) {

        Client client = new Client("localhost", 10000);
        client.connect();
    }
}
