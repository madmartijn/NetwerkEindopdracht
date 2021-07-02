package Server;

import java.io.*;
import java.net.Socket;

public class ServerToPlayerStreams {

    private ObjectInputStream Player1Input;
    private ObjectOutputStream Player1Output;
    private ObjectInputStream Player2Input;
    private ObjectOutputStream Player2Output;
    private DataOutputStream player1Data;
    private DataOutputStream player2Data;

    public ServerToPlayerStreams(Socket player1, Socket player2)
    {
        try {
            Player1Input = new ObjectInputStream(player1.getInputStream());
            Player1Output = new ObjectOutputStream(player1.getOutputStream());
            Player2Input = new ObjectInputStream(player2.getInputStream());
            Player2Output = new ObjectOutputStream(player2.getOutputStream());
            player1Data = new DataOutputStream(player1.getOutputStream());
            player2Data = new DataOutputStream(player2.getOutputStream());
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public ObjectInputStream getPlayer1Input() {
        return Player1Input;
    }

    public ObjectOutputStream getPlayer1Output() {
        return Player1Output;
    }

    public ObjectInputStream getPlayer2Input() {
        return Player2Input;
    }

    public ObjectOutputStream getPlayer2Output() {
        return Player2Output;
    }

    public DataOutputStream getPlayer1Data() {
        return player1Data;
    }

    public DataOutputStream getPlayer2Data() {
        return player2Data;
    }
}
