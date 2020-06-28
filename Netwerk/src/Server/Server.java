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
                ServerSocket serverSocket = new ServerSocket(10000);

                while (true) {
                    Socket player1 = serverSocket.accept();
                    new DataOutputStream(player1.getOutputStream()).write(1);
                    System.out.println("Player 1 connected");

                    Socket player2 = serverSocket.accept();
                    new DataOutputStream(player2.getOutputStream()).write(2);
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

    private ObjectInputStream fromPlayer1;
    private ObjectOutputStream toPlayer1;
    private ObjectInputStream fromPlayer2;
    private ObjectOutputStream toPlayer2;

    private DataOutputStream toPlayer1Data;
    private DataOutputStream toPlayer2Data;

    private boolean continueToPlay = true;

    private Window window = new Window();
    private Tile2[][] gameBoard;

    public HandleASession(Socket player1, Socket player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void run() {

        try {
            fromPlayer1 = new ObjectInputStream(player1.getInputStream());
            toPlayer1 = new ObjectOutputStream(player1.getOutputStream());
            fromPlayer2 = new ObjectInputStream(player2.getInputStream());
            toPlayer2 = new ObjectOutputStream(player2.getOutputStream());

            toPlayer1Data = new DataOutputStream(player1.getOutputStream());
            toPlayer2Data = new DataOutputStream(player2.getOutputStream());

            toPlayer1Data.write(1);

            while(true) {
                System.out.println("The game is starting");

                this.gameBoard = (Tile2[][]) fromPlayer1.readObject();

                if(this.window.isWon()){
                    toPlayer1Data.write(3);
                    toPlayer2Data.write(3);
                    sendMove(toPlayer2, this.gameBoard);
                    System.out.println("Player 1 has won");
                    break;
                }else {
                    System.out.println("Player 2 turn");
                    toPlayer2Data.write(5);
                    sendMove(toPlayer2, this.gameBoard);
                }

                this.gameBoard = (Tile2[][]) fromPlayer2.readObject();

                if(this.window.isWon()) {
                    toPlayer1Data.write(4);
                    toPlayer2Data.write(4);
                    sendMove(toPlayer1, this.gameBoard);
                    System.out.println("Player 2 has won");
                    break;
                }else {
                    System.out.println("Player 1 turn");
                    toPlayer1Data.write(5);
                    sendMove(toPlayer1, this.gameBoard);
                }
            }
        }catch (IOException | ClassNotFoundException e) {
            System.out.println("error" + e.getLocalizedMessage());
        }
    }

    private void sendMove(ObjectOutputStream toPlayer, Tile2[][] gameBoard) throws IOException {
        toPlayer.writeObject(gameBoard);
    }
}