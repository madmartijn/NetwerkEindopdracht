package Pieces;

import Board.*;
import Board.Tile.*;
import Board.Move.*;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece{

    private static int[] CANDIDATE_MOVE_COORDINATES = {7, 8, 9, 16};
    private boolean isBackLine;

    public Pawn(boolean isWhite, boolean isBackLine) {
        super(isWhite);
        this.isBackLine = isBackLine;

        if (!isWhite){
            if (!isBackLine){
                try {
                    super.setImage(ImageIO.read(this.getClass().getResourceAsStream("/pawnBlack.png")));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else {
                try {
                    super.setImage(ImageIO.read(this.getClass().getResourceAsStream("/pawnBlackBackline.png")));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }else {
            if (!isBackLine){
                try {
                    super.setImage(ImageIO.read(this.getClass().getResourceAsStream("/pawnWhite.png")));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else {
                try {
                    super.setImage(ImageIO.read(this.getClass().getResourceAsStream("/pawnWhiteBackline.png")));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public List<Move> PossibleMoves(Board board) {

        List<Move> legalMoves = new ArrayList<>();
//        int candidateDestinationCoordinate;
//        int pieceDirection;
//
//        for(int currentCandidateOffset : CANDIDATE_MOVE_COORDINATES){
//
//            if(isWhite()) {
//                pieceDirection = -1;
//                candidateDestinationCoordinate = this.piecePosition - currentCandidateOffset;
//            }else {
//                pieceDirection = 1;
//                candidateDestinationCoordinate = this.piecePosition + currentCandidateOffset;
//            }
//
//            if(!BoardUtils.isValidTileCoordinate(candidateDestinationCoordinate)){
//                continue;
//            }
//
//            if(currentCandidateOffset == 8 && !board.getTile(candidateDestinationCoordinate).isTileOccupied()){
//                legalMoves.add(new MajorMove(board, this, candidateDestinationCoordinate));
//            }else if(currentCandidateOffset == 16 && this.isFirstMove() &&
//                    (BoardUtils.SECOND_ROW[this.piecePosition] && !isWhite()) ||
//                    (BoardUtils.SEVENTH_ROW[this.piecePosition] && isWhite())){
//                int behindCandidateDestinationCoordinate = this.piecePosition + (pieceDirection * 8);
//
//                if(!board.getTile(behindCandidateDestinationCoordinate).isTileOccupied() &&
//                        !board.getTile(candidateDestinationCoordinate).isTileOccupied()){
//                    legalMoves.add(new MajorMove(board, this, candidateDestinationCoordinate));
//                }
//            }else if(currentCandidateOffset == 7 &&
//                    !(BoardUtils.EIGHT_COLUMN[this.piecePosition] && isWhite() ||
//                    (BoardUtils.FIRST_COLUMN[this.piecePosition] && !isWhite()))){
//                if(board.getTile(candidateDestinationCoordinate).isTileOccupied()){
//                    Piece pieceOnCandidate = board.getTile(candidateDestinationCoordinate).getPiece();
//                    boolean color = pieceOnCandidate.isWhite();
//
//                    if (color != isWhite()){
//                        legalMoves.add(new MajorMove(board, this, candidateDestinationCoordinate));
//                    }
//                }
//            }else if(currentCandidateOffset == 9 &&
//                    !(BoardUtils.FIRST_COLUMN[this.piecePosition] && isWhite() ||
//                            (BoardUtils.EIGHT_COLUMN[this.piecePosition] && !isWhite()))){
//
//                if(board.getTile(candidateDestinationCoordinate).isTileOccupied()) {
//                    Piece pieceOnCandidate = board.getTile(candidateDestinationCoordinate).getPiece();
//                    boolean color = pieceOnCandidate.isWhite();
//
//                    if (color != isWhite()) {
//                        legalMoves.add(new MajorMove(board, this, candidateDestinationCoordinate));
//                    }
//                }
//            }
//        }
        return legalMoves;
    }
}
