package Window;

import Board.Board;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.jfree.fx.FXGraphics2D;
import org.jfree.fx.ResizableCanvas;
import static javafx.application.Application.launch;

public class Window extends Application {

    private Board board = new Board(new Board.Builder());
    private Stage stage;

    @Override
    public void start(Stage stage) throws Exception{
        this.stage = stage;
        javafx.scene.canvas.Canvas canvas = new javafx.scene.canvas.Canvas(1000, 1000);
        BorderPane mainPane = new BorderPane();
        mainPane.setCenter(canvas);
        FXGraphics2D g2d = new FXGraphics2D(canvas.getGraphicsContext2D());


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
    }


    public void draw(FXGraphics2D graphics){

    }

    public void update(double deltaTime){

    }






    public static void main(String[] args) {
        launch(Window.class);
    }
}
