package Pieces;

import Board.*;
import Board.Move.*;
import Board.Tile.*;

import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece{

    private static int[] CANDIDATE_MOVE_VECTOR = {-9, -8, -7, -1, 1, 7, 8, 9};

    public Queen(int piecePosition, boolean isWhite) {
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
        return BoardUtils.FIRST_COLUMN[currentPosition] && (candidateOffset == -9 || candidateOffset == -1 || candidateOffset == 7);
    }

    private static boolean isEightColumnExclusion(int currentPosition, int candidateOffset){
        return BoardUtils.EIGHT_COLUMN[currentPosition] && (candidateOffset == 9 || candidateOffset == 1 || candidateOffset == -7);
    }
}
