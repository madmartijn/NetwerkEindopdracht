package Window;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class PlayerToServerStreams {

    private ObjectInputStream ServerInput;
    private ObjectOutputStream ServerOutput;

    public PlayerToServerStreams(Socket socket)
    {
        try{
            ServerOutput = new ObjectOutputStream(socket.getOutputStream());
            ServerInput = new ObjectInputStream(socket.getInputStream());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public ObjectInputStream getServerInput() {
        return ServerInput;
    }

    public ObjectOutputStream getServerOutput() {
        return ServerOutput;
    }
}
