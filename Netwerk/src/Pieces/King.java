package Pieces;

import Board.*;
import Board.Move.*;
import Board.Tile.*;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class King extends Piece{

    private static int[] CANDIDATE_MOVE_COORDINATE = {-9, -8, -7, -1, 1, 7, 8, 9};

    public King(boolean isWhite) {
        super(isWhite);

        if (!isWhite){
            try {
                super.setImage(ImageIO.read(this.getClass().getResourceAsStream("/kingBlack.png")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            try {
                super.setImage(ImageIO.read(this.getClass().getResourceAsStream("/kingWhite.png")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Move> PossibleMoves(Board board) {

        List<Move> legalMoves = new ArrayList<>();

//        for(int currentCandidateOffset : CANDIDATE_MOVE_COORDINATE){
//           int candidateDestinationCoordinate = this.piecePosition + currentCandidateOffset;
//
//           if(BoardUtils.isValidTileCoordinate(candidateDestinationCoordinate)){
//
//               if(isFirstColumnException(this.piecePosition, currentCandidateOffset) ||
//               isEightColumnException(this.piecePosition, currentCandidateOffset)){
//                   continue;
//               }
//
//               Tile candidateDestinationTile = board.getTile(candidateDestinationCoordinate);
//
//               if(!candidateDestinationTile.isTileOccupied()){
//                   legalMoves.add(new MajorMove(board, this, candidateDestinationCoordinate));
//               }else {
//                   final Piece pieceAtDestination = candidateDestinationTile.getPiece();
//                   final boolean color = pieceAtDestination.isWhite();
//
//                   if(color != isWhite()){
//                       legalMoves.add(new AttackMove(board, this, candidateDestinationCoordinate, pieceAtDestination));
//                   }
//               }
//           }
//        }
        return legalMoves;
    }

    private static boolean isFirstColumnException (final int currentPosition, final int candidateOffset) {
        return BoardUtils.FIRST_COLUMN[currentPosition] && (candidateOffset == -9 || candidateOffset == -1
                || candidateOffset == 7);
    }

    private static boolean isEightColumnException (final int currentPosition, final int candidateOffset){
        return BoardUtils.EIGHT_COLUMN[currentPosition] && (candidateOffset == -7 || candidateOffset == 1
                || candidateOffset == 9);
    }
}
