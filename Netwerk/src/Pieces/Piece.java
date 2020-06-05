package Pieces;

import Board.Board;
import Board.Move.Move;

import java.util.List;

public abstract class Piece {

    protected final int piecePosition;
    private boolean isWhite;
    private boolean isFirstMove;

    public Piece(int piecePosition, boolean isWhite) {
        this.piecePosition = piecePosition;
        this.isWhite = isWhite;
        this.isFirstMove = false;
    }

    public int getPiecePosition() {
        return this.piecePosition;
    }

    public boolean isWhite() {
        return this.isWhite;
    }

    public boolean isFirstMove() {return this.isFirstMove;}

    public abstract List<Move> PossibleMoves(Board board);

}
