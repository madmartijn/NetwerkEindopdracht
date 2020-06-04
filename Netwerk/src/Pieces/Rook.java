package Pieces;

import Board.*;
import Board.Tile.*;
import Board.Move.*;

import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece{

    private static int[] CANDIDATE_MOVE_VECTOR = {-8, -1, 1, 8};


    public Rook(int piecePosition, boolean isWhite) {
        super(piecePosition, isWhite);
    }

    @Override
    public List<Move> PossibleMoves(Board board) {

        List<Move> legalMoves = new ArrayList<>();

        for(int candidateCoordinateOffset : CANDIDATE_MOVE_VECTOR){

            int candidateDestinationCoordinate = this.piecePosition;

            while(BoardUtils.isValidTileCoordinate(candidateDestinationCoordinate)){

                if(isFirstColumnExclusion(candidateDestinationCoordinate, candidateCoordinateOffset) ||
                        isEightColumnExclusion(candidateDestinationCoordinate, candidateCoordinateOffset)){
                    break;
                }

                candidateDestinationCoordinate += candidateCoordinateOffset;

                if(BoardUtils.isValidTileCoordinate(candidateDestinationCoordinate)){
                    final Tile candidateDestinationTile = board.getTile(candidateDestinationCoordinate);

                    if(!candidateDestinationTile.isTileOccupied()){
                        legalMoves.add(new MajorMove(board, this, candidateDestinationCoordinate));
                    }else {
                        final Piece pieceAtDestination = candidateDestinationTile.getPiece();
                        final boolean color = pieceAtDestination.isWhite();

                        if(color != isWhite()){
                            legalMoves.add(new AttackMove(board, this, candidateDestinationCoordinate, pieceAtDestination));
                        }
                        break;
                    }
                }
            }
        }
        return legalMoves;
    }

    private static boolean isFirstColumnExclusion(int currentPosition, int candidateOffset){
        return BoardUtils.FIRST_COLUMN[currentPosition] && (candidateOffset == -1);
    }

    private static boolean isEightColumnExclusion(int currentPosition, int candidateOffset){
        return BoardUtils.EIGHT_COLUMN[currentPosition] && (candidateOffset == 1);
    }
}