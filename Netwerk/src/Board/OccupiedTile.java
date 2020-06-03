package Board;

import Pieces.Piece;

public class OccupiedTile extends Tile{

    private final Piece piece;

    public OccupiedTile(int tileCoordinate, Piece piece) {
        super(tileCoordinate);
        this.piece = piece;
    }

    @Override
    public boolean isTileOccupied() {
        return true;
    }

    @Override
    public Piece getPiece() {
        return this.piece;
    }
}
