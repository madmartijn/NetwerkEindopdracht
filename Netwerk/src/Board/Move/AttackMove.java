package Board.Move;

import Board.Board;
import Pieces.Piece;

public class AttackMove extends Move{

    public AttackMove(Board board, Piece movedPiece, int destinationCoordinate) {
        super(board, movedPiece, destinationCoordinate);
    }
}
