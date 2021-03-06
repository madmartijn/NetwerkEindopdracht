package Board;

import Board.Tile2;
import javafx.scene.canvas.Canvas;

import java.awt.*;

public class Board {

    private Tile2[][] gameBoard;
    private Canvas canvas;

    public Board(Canvas canvas){
        this.canvas = canvas;
        this.gameBoard = createGameBoard();
    }

    private Tile2[][] createGameBoard() {
        Tile2[][] tiles = new Tile2[8][16];

        int i1 = 0;     //Tracks the position of the first array in the for loop
        int i2 = 0;     //Tracks the position of the second array in the for loop
        while (i1 < tiles.length && i2 < tiles[1].length){
//            System.out.println(i1);
//            System.out.println(i2);

            tiles[i1][i2] = new Tile2(false, i1*60 + (int)this.canvas.getWidth()/4, +i2*60 + 26, 60,60);

            if (i2 == tiles[1].length-1){
                i1++;
                i2 = 0;
            }else {
                i2++;
            }
        }

        return tiles;
    }

    public void draw(Graphics2D graphics, Canvas canvas){

        int i1 = 0;     //Tracks the position of the first array in the for loop
        int i2 = 0;     //Tracks the position of the second array in the for loop
        while (i1 < gameBoard.length && i2 < gameBoard[1].length){
//            graphics.drawRect(i1*64 + (int)canvas.getWidth()/4, -i2*64 - (int)canvas.getHeight()/4, 64,64);

//            gameBoard[i1][i2].getRectangle2D();
            graphics.drawRect(gameBoard[i1][i2].getX(), gameBoard[i1][i2].getY(), gameBoard[i1][i2].getWidth(), gameBoard[i1][i2].getHeight());

            graphics.setColor(Color.gray);
            if (i1%2 != 0){
                if (i2%2 == 0){
                    graphics.fillRect(gameBoard[i1][i2].getX(), gameBoard[i1][i2].getY(), gameBoard[i1][i2].getWidth(), gameBoard[i1][i2].getHeight());
                }
            }else if (i2%2 != 0){
                graphics.fillRect(gameBoard[i1][i2].getX(), gameBoard[i1][i2].getY(), gameBoard[i1][i2].getWidth(), gameBoard[i1][i2].getHeight());
            }

            if (i2 == gameBoard[1].length-1){
                i1++;
                i2 = 0;
            }else {
                i2++;
            }

            graphics.setColor(Color.black);
        }
    }

    public Tile2[][] getGameBoard() {
        return gameBoard;
    }

}
