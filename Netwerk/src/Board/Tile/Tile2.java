package Board.Tile;

import com.sun.javafx.geom.Point2D;
import com.sun.javafx.geom.Rectangle;
import javafx.geometry.Rectangle2D;

public class Tile2 {
    private boolean occupied;
    private Rectangle2D rectangle2D;

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
}
