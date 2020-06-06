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

import java.util.ArrayList;
import java.util.List;

import static javafx.application.Application.launch;

public class Window extends Application {

    private Board board;
    private Stage stage;
    private Canvas canvas;
    private List<Piece> pieces = new ArrayList<Piece>();

    @Override
    public void start(Stage stage) throws Exception{
        this.stage = stage;
        this.canvas = new javafx.scene.canvas.Canvas(1000, 1000);
        BorderPane mainPane = new BorderPane();
        mainPane.setCenter(canvas);
        FXGraphics2D g2d = new FXGraphics2D(canvas.getGraphicsContext2D());
        g2d.scale(1,-1);
        this.board = new Board(new Board.Builder(), this.canvas);


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





        stage.setScene(new Scene(mainPane));
        stage.setTitle("Chess");
        stage.show();
        draw(g2d);

//        gameStart();
    }


    public void draw(FXGraphics2D graphics){
        this.board.draw(graphics, this.canvas);

    }

    public void update(double deltaTime){

    }

    public void gameStart(){
        Tile2[][] gameBoard = this.board.getGameBoard();
        gameBoard[0][0].setOccupied(true);
        Rook black1 = new Rook(gameBoard[0][0],false);
        this.pieces.add(black1);

        for (int i=0; i <= gameBoard[1].length; i++){
            gameBoard[1][i].setOccupied(true);
        }
    }






    public static void main(String[] args) {
        launch(Window.class);
    }
}
