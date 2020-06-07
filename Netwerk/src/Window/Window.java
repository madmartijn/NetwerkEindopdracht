package Window;

import Board.Board;
import Board.Tile.Tile;
import Board.Tile.Tile2;
import Pieces.*;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.jfree.fx.FXGraphics2D;
import org.jfree.fx.ResizableCanvas;

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

        this.canvas.setOnMouseClicked(event -> onMouseClick(event));



        gameStart();


        stage.setScene(new Scene(mainPane));
        stage.setTitle("Chess");
        stage.show();
        draw(g2d);

    }

    private AffineTransform pieceTransform(Tile2 tile){
        AffineTransform tx = new AffineTransform();
        tx.translate(tile.getRectangle2D().getMinX() + 10, tile.getRectangle2D().getMinY() + 9);
        tx.scale(0.05,0.05);
        return tx;
    }


    public void draw(FXGraphics2D graphics){
        graphics.setBackground(Color.white);
        graphics.clearRect(0, 0, (int)canvas.getWidth(), (int)canvas.getHeight());
        this.board.draw(graphics, this.canvas);

        for (Tile2[] tile : this.board.getGameBoard()){
            for (Tile2 tile2 : tile){
                if (tile2.isOccupied()){
                    graphics.drawImage(tile2.getPiece().getImage(), pieceTransform(tile2), null);
                }
            }
        }

    }

    public void update(double deltaTime){

    }

    public void gameStart(){

        gameBoard[0][0].setOccupied(true);
        gameBoard[0][0].setPiece(new Rook(false));

        gameBoard[7][0].setOccupied(true);
        gameBoard[7][0].setPiece(new Rook(false));

        gameBoard[1][0].setOccupied(true);
        gameBoard[1][0].setPiece(new Knight(false));

        gameBoard[6][0].setOccupied(true);
        gameBoard[6][0].setPiece(new Knight(false));

        gameBoard[2][0].setOccupied(true);
        gameBoard[2][0].setPiece(new Bishop(false));

        gameBoard[5][0].setOccupied(true);
        gameBoard[5][0].setPiece(new Bishop(false));

        gameBoard[3][0].setOccupied(true);
        gameBoard[3][0].setPiece(new King(false));

        gameBoard[4][0].setOccupied(true);
        gameBoard[4][0].setPiece(new Queen(false));

        for (int i = 0; i < gameBoard[1].length; i++){
            gameBoard[i][1].setOccupied(true);
            gameBoard[i][1].setPiece(new Pawn(false));
        }

    }

    private void onMouseClick(MouseEvent event){
        System.out.println("MOUSE EVENT");

        if (!this.holdingPiece){
            if (event.getButton() == MouseButton.PRIMARY){
                for (Tile2[] tile2 : this.gameBoard){
                    for (Tile2 tile : tile2){
                        if (tile.getRectangle2D().contains(event.getX(), event.getY()) && tile.isOccupied()){   //Find the selected tile and check if it's occupied to grab the piece
                            System.out.println("TILE SELECTION");
                            this.holdingPiece = true;
                            this.grabbedPiece = tile;
                        }
                    }
                }
            }
        }else {
            if (event.getButton() == MouseButton.PRIMARY){
                for (Tile2[] tile2 : this.gameBoard){
                    for (Tile2 tile : tile2){
                        if (tile.getRectangle2D().contains(event.getX(), event.getY()) && !tile.isOccupied()){  //Target tile is empty, place the piece
                            System.out.println("PLACEMENT");
                            tile.setPiece(this.grabbedPiece.getPiece());
                            tile.setOccupied(true);
                            this.grabbedPiece.removePiece();
                            this.holdingPiece = false;
                        }else if (tile.getRectangle2D().contains(event.getX(), event.getY()) && tile.isOccupied()){     //Target tile is occupied, remove the existing piece and place selected piece.
                            System.out.println("MURDER");
                            tile.removePiece();
                            tile.setOccupied(true);
                            tile.setPiece(this.grabbedPiece.getPiece());
                            this.grabbedPiece.removePiece();
                            this.holdingPiece = false;
                        }
                    }
                }
            }
        }
    }






    public static void main(String[] args) {
        launch(Window.class);
    }
}
