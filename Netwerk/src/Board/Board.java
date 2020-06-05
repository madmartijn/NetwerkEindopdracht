package Board;

import Board.Tile.Tile;
import Pieces.Piece;

import java.util.List;
import java.util.Map;

public class Board {

    private List<Tile> gameBoard;

    private Board(Builder builder){
        this.gameBoard = createGameBoard(builder);
    }

    private List<Tile> createGameBoard(Builder builder) {
        Tile[] tiles = new Tile[64];
    }

    public Tile getTile(int tileCoordinate) {
        return null;
    }

    public static class Builder {

        private Map<Integer, Piece> boardConfig;
        private boolean color;

        public Builder() {

        }

        public Builder setPiece (Piece piece) {
            this.boardConfig.put(piece.getPiecePosition(), piece);
            return this;
        }

        public Builder setMoveMaker (Piece piece) {
            this.color = piece.isWhite();
            return this;
        }

        public Board builder() {
            return new Board(this);
        }
    }
}
