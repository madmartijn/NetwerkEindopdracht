package Pieces;

import Board.Board;
import Board.Move.Move;
import Board.Tile.Tile2;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

public abstract class Piece {

//    protected final int piecePosition;
    private Tile2 piecePosition;
    private boolean isWhite;
    private boolean isFirstMove;
    private BufferedImage image;

    public Piece( boolean isWhite) {
        this.isWhite = isWhite;
        this.isFirstMove = false;
    }

    public Tile2 getPiecePosition() {
        return this.piecePosition;
    }

    public void setPiecePosition(Tile2 piecePosition) {
        this.piecePosition = piecePosition;
    }

    public boolean isWhite() {
        return this.isWhite;
    }

    public boolean isFirstMove() {return this.isFirstMove;}

    public abstract List<Move> PossibleMoves(Board board);

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
}
