import Server.Server;

public class Main {

    public static void main(String[] args) {
        int port = 10000;
        Server server = new Server(port);
        server.connect();
    }
}
