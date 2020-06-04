package Board;

import Board.Tile.Tile;
import Pieces.Piece;

import java.util.Map;

public class Board {

    private Board(Builder builder){

    }

    public Tile getTile(int tileCoordinate) {
        return null;
    }

    public static class Builder {

        private Map<Integer, Piece> boardConfig;
        private Piece piece;

        public Builder() {

        }

        public Builder setPiece (Piece piece) {
            this.boardConfig.put(piece.getPiecePosition(), piece);
            return this;
        }

        public Builder setMoveMaker (Piece piece) {
            boolean this.piece.isWhite() =  piece.isWhite();
        }

        public Board builder() {
            return new Board(this);
        }
    }
}
