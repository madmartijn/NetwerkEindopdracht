package Board.Tile;

import Board.Board;
import Board.Tile.Tile;
import Pieces.Piece;

public class EmptyTile extends Tile {

    public EmptyTile(int tileCoordinate) {
        super(tileCoordinate);
    }

    @Override
    public boolean isTileOccupied() {
        return false;
    }

    @Override
    public Piece getPiece() {
        return null;
    }
}
