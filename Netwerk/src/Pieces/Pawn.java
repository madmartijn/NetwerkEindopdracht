package Pieces;

import Board.*;
import Board.Tile.*;
import Board.Move.*;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece{

    private static int[] CANDIDATE_MOVE_COORDINATES = {8};

    public Pawn(int piecePosition, boolean isWhite) {
        super(piecePosition, isWhite);
    }

    @Override
    public List<Move> PossibleMoves(Board board) {

        List<Move> legalMoves = new ArrayList<>();
        int candidateDestinationCoordinate;

        for(int currentCandidateOffset : CANDIDATE_MOVE_COORDINATES){

            if(isWhite()) {
                candidateDestinationCoordinate = this.piecePosition - currentCandidateOffset;
            }else {
                candidateDestinationCoordinate = this.piecePosition + currentCandidateOffset;
            }

            if(!BoardUtils.isValidTileCoordinate(candidateDestinationCoordinate)){
                continue;
            }

            if(currentCandidateOffset == 8 && !board.getTile(candidateDestinationCoordinate).isTileOccupied()){
                legalMoves.add(new MajorMove(board, this, candidateDestinationCoordinate));
            }

        }

        return legalMoves;
    }
}
