package Board.Move;

import Board.Board;
import Pieces.Piece;

public abstract class Move {

    private Board board;
    private Piece movedPiece;
    private int destinationCoordinate;

    public Move(Board board, Piece movedPiece, int destinationCoordinate) {
        this.board = board;
        this.movedPiece = movedPiece;
        this.destinationCoordinate = destinationCoordinate;
    }
}
