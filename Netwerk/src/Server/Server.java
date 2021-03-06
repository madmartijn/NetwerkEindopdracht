package Server;

import Board.Tile2;
import Window.Window;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public void Start () {
        new Thread(() -> {
            try{
                ServerSocket serverSocket = new ServerSocket(10101);

                while (true) {
                    Socket player1 = serverSocket.accept();
                    System.out.println("Player 1 connected");

                    Socket player2 = serverSocket.accept();
                    System.out.println("Player 2 connected");

                    new Thread(new HandleASession(player1, player2)).start();
                    System.out.println("All players connected");
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

class HandleASession implements Runnable{
    private Socket player1;
    private Socket player2;

    private ServerToPlayerStreams ObjectStreams;

    private boolean continueToPlay = true;

    private Window window = new Window();
    private Tile2[][] gameBoard;

    public HandleASession(Socket player1, Socket player2) {
        this.player1 = player1;
        this.player2 = player2;

        run();
    }

    public void run() {

        try {
            ObjectStreams = new ServerToPlayerStreams(player1, player2);

            ObjectStreams.getPlayer1Data().writeInt(1);
            ObjectStreams.getPlayer2Data().writeInt(2);

            while(true) {
                System.out.println("The game is starting");

                this.gameBoard = (Tile2[][]) ObjectStreams.getPlayer1Input().readObject();
                System.out.println("I got the gameBoard: " + this.gameBoard);

                if(this.window.isWon()){
                    ObjectStreams.getPlayer1Data().writeInt(3);
                    ObjectStreams.getPlayer2Data().writeInt(3);
                    sendMove(ObjectStreams.getPlayer2Output(), this.gameBoard);
                    System.out.println("Player 1 has won");
                    ObjectStreams.closeStreams();
                    break;
                }else {
                    System.out.println("Player 2 turn");
                    ObjectStreams.getPlayer2Data().writeInt(5);
                    sendMove(ObjectStreams.getPlayer2Output(), this.gameBoard);
                }

                this.gameBoard = (Tile2[][]) ObjectStreams.getPlayer2Input().readObject();

                if(this.window.isWon()) {
                    ObjectStreams.getPlayer1Data().writeInt(4);
                    ObjectStreams.getPlayer2Data().writeInt(4);
                    sendMove(ObjectStreams.getPlayer1Output(), this.gameBoard);
                    System.out.println("Player 2 has won");
                    ObjectStreams.closeStreams();
                    break;
                }else {
                    System.out.println("Player 1 turn");
                    ObjectStreams.getPlayer1Data().writeInt(5);
                    sendMove(ObjectStreams.getPlayer1Output(), this.gameBoard);
                }
            }
        }catch (IOException | ClassNotFoundException e) {
            System.out.println("error" + e.getLocalizedMessage());
        }
    }

    private void sendMove(ObjectOutputStream toPlayer, Tile2[][] gameBoard) throws IOException {
        toPlayer.writeObject(gameBoard);
        toPlayer.flush();
    }
}