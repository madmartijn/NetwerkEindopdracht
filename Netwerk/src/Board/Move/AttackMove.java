package Board.Move;

import Board.Board;
import Pieces.Piece;

public class AttackMove extends Move{

    private Piece attackedPiece;

    public AttackMove(Board board, Piece movedPiece, int destinationCoordinate, Piece attackedPiece) {
        super(board, movedPiece, destinationCoordinate);
        this.attackedPiece = attackedPiece;
    }
}
