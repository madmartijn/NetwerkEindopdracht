package Window;

import Board.Board;
import Board.Tile.Tile;
import Board.Tile.Tile2;
import Pieces.Piece;
import Pieces.Rook;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.jfree.fx.FXGraphics2D;
import org.jfree.fx.ResizableCanvas;

import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;

import static javafx.application.Application.launch;

public class Window extends Application {

    private Board board;
    private Stage stage;
    private Canvas canvas;

    @Override
    public void start(Stage stage) throws Exception{
        this.stage = stage;
        this.canvas = new javafx.scene.canvas.Canvas(1000, 1000);
        BorderPane mainPane = new BorderPane();
        mainPane.setCenter(canvas);
        FXGraphics2D g2d = new FXGraphics2D(canvas.getGraphicsContext2D());
        g2d.scale(1,1);
        this.board = new Board(this.canvas);


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



        gameStart();


        stage.setScene(new Scene(mainPane));
        stage.setTitle("Chess");
        stage.show();
        draw(g2d);

    }

    private AffineTransform pieceTransform(Tile2 tile){
        AffineTransform tx = new AffineTransform();
        tx.translate(tile.getRectangle2D().getMinX() + 9, tile.getRectangle2D().getMinY() + 9);
        tx.scale(0.05,0.05);
        return tx;
    }


    public void draw(FXGraphics2D graphics){
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
        Tile2[][] gameBoard = this.board.getGameBoard();
        gameBoard[0][0].setOccupied(true);
        gameBoard[0][0].setPiece(new Rook(false));

    }






    public static void main(String[] args) {
        launch(Window.class);
    }
}
