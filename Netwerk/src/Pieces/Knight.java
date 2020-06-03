package Pieces;

import Board.*;

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

        for (int currentCandidate : POSSIBLE_MOVES){

            candidateDestinationCoordinate = this.piecePosition + currentCandidate;

            if(true){
                final Tile candidateDestinationTile = board.getTile(candidateDestinationCoordinate);

                if(!candidateDestinationTile.isTileOccupied()){
                    legalMoves.add(new Move());
                }else {
                    final Piece pieceAtDestination = candidateDestinationTile.getPiece();
                    final boolean color = pieceAtDestination.isWhite();

                    if(color != isWhite()){
                        legalMoves.add(new Move());
                    }
                }
            }
        }

        return legalMoves;
    }
}
