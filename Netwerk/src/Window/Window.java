package Window;

import Board.Board;
import Board.Tile2;
import Pieces.*;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.jfree.fx.FXGraphics2D;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;

import static javafx.application.Application.launch;

public class Window extends Application {

    private Board board;
    private Stage stage;
    private Canvas canvas;
    private Tile2[][] gameBoard;

    private boolean holdingPiece;
    private Tile2 grabbedPiece;
    private boolean userIsWhite;
    private boolean gameInProgress;
    private List<Tile2> allowedMoves = new ArrayList<>();

    private int status;

    @Override
    public void start(Stage stage) throws Exception{
        this.stage = stage;
        this.canvas = new javafx.scene.canvas.Canvas(1000, 1000);
        BorderPane mainPane = new BorderPane();
        mainPane.setCenter(canvas);
        FXGraphics2D g2d = new FXGraphics2D(canvas.getGraphicsContext2D());
        g2d.scale(1,1);
        this.board = new Board(this.canvas);
        this.gameBoard = this.board.getGameBoard();


        new AnimationTimer() {
            long last = -1;

            @Override
            public void handle(long now) {
                if (last == -1)
                    last = now;
                update((now - last) / 1000000000.0);
                last = now;
                draw(g2d);
            }
        }.start();

        this.canvas.setOnMouseClicked(event -> { onMouseClick(event);
        });



//        gameStart();


        stage.setScene(new Scene(mainPane));
        stage.setTitle("Chess");
        stage.show();
        draw(g2d);

    }

    private AffineTransform pieceTransform(Tile2 tile){
        AffineTransform tx = new AffineTransform();
        tx.translate(tile.getX() + 5, tile.getY() + 5);
        tx.scale(0.1,0.1);
        return tx;
    }


    public void draw(FXGraphics2D graphics){
        graphics.setBackground(Color.white);
        graphics.clearRect(0, 0, (int)canvas.getWidth(), (int)canvas.getHeight());
        this.board.draw(graphics, this.canvas);

        if (holdingPiece){
            graphics.setColor(Color.CYAN);
            for (Tile2 tile : allowedMoves){
                graphics.drawRect(tile.getX(), tile.getY(), tile.getWidth(), tile.getHeight());
            }
            graphics.setColor(Color.black);
        }

        for (Tile2[] tile : this.board.getGameBoard()){
            for (Tile2 tile2 : tile){
                if (tile2.isOccupied()){
                    graphics.drawImage(tile2.getPiece().getImage(), pieceTransform(tile2), null);
                }
            }
        }

        //UI elements
        //White selector
        graphics.drawRect(5,5,85,25);
        if (userIsWhite){
            graphics.setColor(Color.CYAN);
            graphics.fillRect(5,5,85,25);
            graphics.setColor(Color.black);
        }
        graphics.drawString("Colour: White", 10,20);

        //Black selector
        graphics.drawRect(5,35,85,25);
        if (!userIsWhite) {
            graphics.setColor(Color.CYAN);
            graphics.fillRect(5,35,85,25);
            graphics.setColor(Color.black);
        }
        graphics.drawString("Colour: Black", 10, 50);

        //Start button
        graphics.drawRect(5, 65, 85, 25);
        graphics.setColor(Color.green);
        graphics.fillRect(5, 65, 85, 25);
        graphics.setColor(Color.black);
        graphics.drawString("Start game", 10, 80);
    }

    public void update(double deltaTime){

    }

    public void gameStart(){

        gameBoard[0][4].setOccupied(true);
        gameBoard[0][4].setPiece(new Rook(false));

        gameBoard[7][4].setOccupied(true);
        gameBoard[7][4].setPiece(new Rook(false));

        gameBoard[1][4].setOccupied(true);
        gameBoard[1][4].setPiece(new Knight(false));

        gameBoard[6][4].setOccupied(true);
        gameBoard[6][4].setPiece(new Knight(false));

        gameBoard[2][4].setOccupied(true);
        gameBoard[2][4].setPiece(new Bishop(false));

        gameBoard[5][4].setOccupied(true);
        gameBoard[5][4].setPiece(new Bishop(false));

        gameBoard[3][4].setOccupied(true);
        gameBoard[3][4].setPiece(new King(false));

        gameBoard[4][4].setOccupied(true);
        gameBoard[4][4].setPiece(new Queen(false));

        for (int i = 0; i < gameBoard.length; i++){
            gameBoard[i][5].setOccupied(true);
            gameBoard[i][5].setPiece(new Pawn(false, false));
        }

        for (int i = 0; i < gameBoard.length; i++){
            gameBoard[i][3].setOccupied(true);
            gameBoard[i][3].setPiece(new Pawn(false, true));
        }

        for (int i = 0; i < gameBoard.length; i++){
            gameBoard[i][12].setOccupied(true);
            gameBoard[i][12].setPiece(new Pawn(true, true));
        }

        for (int i = 0; i < gameBoard.length; i++){
            gameBoard[i][10].setOccupied(true);
            gameBoard[i][10].setPiece(new Pawn(true, false));
        }

        gameBoard[4][11].setOccupied(true);
        gameBoard[4][11].setPiece(new Queen(true));

        gameBoard[3][11].setOccupied(true);
        gameBoard[3][11].setPiece(new King(true));

        gameBoard[5][11].setOccupied(true);
        gameBoard[5][11].setPiece(new Bishop(true));

        gameBoard[2][11].setOccupied(true);
        gameBoard[2][11].setPiece(new Bishop(true));

        gameBoard[6][11].setOccupied(true);
        gameBoard[6][11].setPiece(new Knight(true));

        gameBoard[1][11].setOccupied(true);
        gameBoard[1][11].setPiece(new Knight(true));

        gameBoard[7][11].setOccupied(true);
        gameBoard[7][11].setPiece(new Rook(true));

        gameBoard[0][11].setOccupied(true);
        gameBoard[0][11].setPiece(new Rook(true));
    }

    private void onMouseClick(MouseEvent event) {
        System.out.println("MOUSE EVENT");
        System.out.println(gameInProgress);

        if (gameInProgress){
            if (!this.holdingPiece){
                if (event.getButton() == MouseButton.PRIMARY){
                    for (Tile2[] tile2 : this.gameBoard){
                        for (Tile2 tile : tile2){
                            if (new Rectangle2D(tile.getX(), tile.getY(), tile.getWidth(), tile.getHeight()).contains(event.getX(), event.getY()) && tile.isOccupied() && tile.getPiece().isWhite() == userIsWhite){   //Find the selected tile and check if it's occupied to grab the piece
                                System.out.println("TILE SELECTION");
                                this.holdingPiece = true;
                                this.grabbedPiece = tile;
                                this.allowedMoves = this.grabbedPiece.getPiece().PossibleMoves(this.gameBoard, tile);
                                this.status = 1;
                            }
                        }
                    }
                }
            }else {
                if (event.getButton() == MouseButton.PRIMARY){
                    for (Tile2[] tile2 : this.gameBoard){
                        for (Tile2 tile : tile2){
                            if (new Rectangle2D(tile.getX(), tile.getY(), tile.getWidth(), tile.getHeight()).contains(event.getX(), event.getY()) && !tile.isOccupied()){  //Target tile is empty, place the piece      //TODO add  && allowedMoves.contains(tile)
                                System.out.println("PLACEMENT");
                                tile.setPiece(this.grabbedPiece.getPiece());
                                tile.setOccupied(true);
                                this.grabbedPiece.removePiece();
                                this.holdingPiece = false;
                            }else if (new Rectangle2D(tile.getX(), tile.getY(), tile.getWidth(), tile.getHeight()).contains(event.getX(), event.getY()) && tile.isOccupied()  && tile.getPiece().isWhite() != grabbedPiece.getPiece().isWhite()){     //Target tile is occupied, remove the existing piece and place selected piece.        //TODO add  && allowedMoves.contains(tile)
                                System.out.println("MURDER");

                                if (tile.getPiece().isKing()){
                                    gameInProgress = false;
                                }

                                tile.removePiece();
                                tile.setOccupied(true);
                                tile.setPiece(this.grabbedPiece.getPiece());
                                this.grabbedPiece.removePiece();
                                this.holdingPiece = false;
                                this.status = 3;
                            }else {
                                this.holdingPiece = false;
                                this.status = 4;
                            }
                        }
                    }
                }
            }
            System.out.println(this.status);
        }else {
            if (new Rectangle2D(5,5,85,25).contains(event.getX(),event.getY())){
                userIsWhite = true;
            }else if (new Rectangle2D(5,35,85,25).contains(event.getX(), event.getY())){
                userIsWhite = false;
            }else if (new Rectangle2D(5, 65,85,25).contains(event.getX(), event.getY())){
                gameInProgress = true;
                gameStart();
            }
        }

    }

    public static void main(String[] args) {



        launch(Window.class);

    }

    public Tile2[][] getGameBoard() {
        return gameBoard;
    }
}
