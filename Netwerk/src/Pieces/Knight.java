package Pieces;

import Board.*;
import Board.Move.AttackMove;
import Board.Move.MajorMove;
import Board.Move.Move;
import Board.Tile.Tile;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece{

    private final static int[] POSSIBLE_MOVES = {-17, -15, -10, -6, 6, 10, 15, 17};

    public Knight(int piecePosition, boolean isWhite) {
        super(piecePosition, isWhite);
    }

    // calculates all legal moves for a knight to make.
    @Override
    public List<Move> PossibleMoves(Board board) {

        int candidateDestinationCoordinate;
        List<Move> legalMoves = new ArrayList<>();

        for (int currentCandidateOffset : POSSIBLE_MOVES){

            candidateDestinationCoordinate = this.piecePosition + currentCandidateOffset;

            if(BoardUtils.isValidTileCoordinate(candidateDestinationCoordinate)){

                if(isFirstColumnException(this.piecePosition, currentCandidateOffset) ||
                isSecondColumnException(this.piecePosition, currentCandidateOffset) ||
                isSeventhColumnException(this.piecePosition, currentCandidateOffset) ||
                isEightColumnException(this.piecePosition, currentCandidateOffset)){
                    continue;
                }

                final Tile candidateDestinationTile = board.getTile(candidateDestinationCoordinate);

                if(!candidateDestinationTile.isTileOccupied()){
                    legalMoves.add(new MajorMove(board, this, candidateDestinationCoordinate));
                }else {
                    final Piece pieceAtDestination = candidateDestinationTile.getPiece();
                    final boolean color = pieceAtDestination.isWhite();

                    if(color != isWhite()){
                        legalMoves.add(new AttackMove(board, this, candidateDestinationCoordinate, pieceAtDestination));
                    }
                }
            }
        }
        return legalMoves;
    }

    private static boolean isFirstColumnException (final int currentPosition, final int candidateOffset) {
        return BoardUtils.FIRST_COLUMN[currentPosition] && (candidateOffset == -17 || candidateOffset == -10
                || candidateOffset == 6 || candidateOffset == 15);
    }

    private static boolean isSecondColumnException (final int currentPosition, final int candidateOffset){
        return BoardUtils.SECOND_COLUMN[currentPosition] && (candidateOffset == -10 || candidateOffset == 6);
    }

    private static boolean isSeventhColumnException (final int currentPosition, final int candidateOffset){
        return BoardUtils.SEVENTH_COLUMN[currentPosition] && (candidateOffset == 10 || candidateOffset == -6);
    }

    private static boolean isEightColumnException (final int currentPosition, final int candidateOffset){
        return BoardUtils.EIGHT_COLUMN[currentPosition] && (candidateOffset == 17 || candidateOffset == 10
                || candidateOffset == -6 || candidateOffset == -15);
    }
}
