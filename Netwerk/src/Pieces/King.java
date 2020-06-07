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
    private boolean isKing;

    public King(boolean isWhite) {
        super(isWhite);
        isKing = true;

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
    public List<Tile2> PossibleMoves(Tile2[][] gameBoard, Tile2 currentTile) {
        List<Tile2> legalMoves = new ArrayList<>();


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

    @Override
    public boolean isKing() {
        return isKing;
    }
}
