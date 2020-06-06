package Board;

import Board.Tile.Tile;
import Board.Tile.Tile2;
import Pieces.Piece;
import com.sun.javafx.geom.Shape;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.Canvas;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Board {

    private Tile2[][] gameBoard;
    private Canvas canvas;

    public Board(Builder builder, Canvas canvas){
        this.gameBoard = createGameBoard(builder);
        this.canvas = canvas;
    }

    private Tile2[][] createGameBoard(Builder builder) {
        Tile2[][] tiles = new Tile2[8][8];

        int i1 = 0;     //Tracks the position of the first array in the for loop
        int i2 = 0;     //Tracks the position of the second array in the for loop
        while (i1 < tiles.length && i2 < tiles[1].length){
            System.out.println(i1);
            System.out.println(i2);

            tiles[i1][i2] = new Tile2(false, new Rectangle2D(i1*64 + (int)this.canvas.getWidth()/4, -i2*64 - (int)this.canvas.getHeight()/4, 64,64));

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
            graphics.drawRect(i1*64 + (int)canvas.getWidth()/4, -i2*64 - (int)canvas.getHeight()/4, 64,64);

            if (i1%2 != 0){
                if (i2%2 == 0){
                    graphics.fillRect(i1*64 + (int)canvas.getWidth()/4, -i2*64 - (int)canvas.getHeight()/4, 64,64);
                }
            }else if (i2%2 != 0){
                graphics.fillRect(i1*64 + (int)canvas.getWidth()/4, -i2*64 - (int)canvas.getHeight()/4, 64,64);
            }

            if (i2 == gameBoard[1].length-1){
                i1++;
                i2 = 0;
            }else {
                i2++;
            }
        }
    }

    public Tile getTile(int tileCoordinate) {
        return null;
    }

    public Tile2[][] getGameBoard() {
        return gameBoard;
    }

    public static class Builder {

        private Map<Integer, Piece> boardConfig;
        private boolean color;

        public Builder() {

        }

        public Builder setPiece (Piece piece) {
//            this.boardConfig.put(piece.getPiecePosition(), piece);
            return this;
        }

        public Builder setMoveMaker (Piece piece) {
            this.color = piece.isWhite();
            return this;
        }

//        public Board builder() {
//            return new Board(this, this);
//        }
    }
}
