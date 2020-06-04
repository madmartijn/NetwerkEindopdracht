package Board.Move;

import Board.Board;
import Pieces.Piece;

public class MajorMove extends Move{
    public MajorMove(Board board, Piece movedPiece, int destinationCoordinate) {
        super(board, movedPiece, destinationCoordinate);
    }
}
