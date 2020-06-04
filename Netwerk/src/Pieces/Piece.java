package Pieces;

import Board.Board;
import Board.Move.Move;

import java.util.List;

public abstract class Piece {

    protected final int piecePosition;
    private boolean isWhite;

    public Piece(int piecePosition, boolean isWhite) {
        this.piecePosition = piecePosition;
        this.isWhite = isWhite;
    }

    public boolean isWhite() {
        return this.isWhite;
    }

    public abstract List<Move> PossibleMoves(Board board);

}
