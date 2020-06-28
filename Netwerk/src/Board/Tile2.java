package Board;

import Pieces.Piece;
import com.sun.javafx.geom.Point2D;
import com.sun.javafx.geom.Rectangle;
import javafx.geometry.Rectangle2D;

import java.io.Serializable;

public class Tile2 implements Serializable {
    private boolean occupied;
//    private Rectangle2D rectangle2D;
    private Piece piece;

    private int x;
    private int y;
    private int width;
    private int height;

    public Tile2(Boolean occupied, int x, int y, int width, int height) {
        this.occupied = occupied;
//        this.rectangle2D = rectangle2D;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }


    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

//    public Rectangle2D getRectangle2D() {
//        return rectangle2D;
//    }

//    public void setRectangle2D(Rectangle2D rectangle2D) {
//        this.rectangle2D = rectangle2D;
//    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public void removePiece(){
        this.occupied = false;
        this.piece = null;
        System.out.println("piece removed");
    }
}
