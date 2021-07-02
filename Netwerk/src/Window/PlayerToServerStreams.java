package Window;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class PlayerToServerStreams {

    private ObjectInputStream ServerInput;
    private ObjectOutputStream ServerOutput;
    private DataInputStream dataInput;

    public PlayerToServerStreams(Socket socket)
    {
        try{
            ServerOutput = new ObjectOutputStream(socket.getOutputStream());
            ServerInput = new ObjectInputStream(socket.getInputStream());
            dataInput = new DataInputStream(socket.getInputStream());
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

    public DataInputStream getDataInput() {
        return dataInput;
    }

    public void closeStreams()
    {
        try {
            this.dataInput.close();
            this.ServerInput.close();
            this.ServerOutput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
