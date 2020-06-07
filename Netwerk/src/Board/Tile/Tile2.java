package Board.Tile;

import Pieces.Piece;
import com.sun.javafx.geom.Point2D;
import com.sun.javafx.geom.Rectangle;
import javafx.geometry.Rectangle2D;

import java.io.Serializable;

public class Tile2 implements Serializable {
    private boolean occupied;
    private Rectangle2D rectangle2D;
    private Piece piece;

    public Tile2(Boolean occupied, Rectangle2D rectangle2D) {
        this.occupied = occupied;
        this.rectangle2D = rectangle2D;
    }


    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public Rectangle2D getRectangle2D() {
        return rectangle2D;
    }

    public void setRectangle2D(Rectangle2D rectangle2D) {
        this.rectangle2D = rectangle2D;
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
