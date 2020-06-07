package Pieces;

import Board.*;
import Board.Move.*;
import Board.Tile.*;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece{

    private static int[] CANDIDATE_MOVE_VECTOR = {-9, -8, -7, -1, 1, 7, 8, 9};

    public Queen(boolean isWhite) {
        super(isWhite);

        if (!isWhite){
            try {
                super.setImage(ImageIO.read(this.getClass().getResourceAsStream("/queenBlack.png")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            try {
                super.setImage(ImageIO.read(this.getClass().getResourceAsStream("/queenWhite.png")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Tile2> PossibleMoves(Tile2[][] gameBoard, Tile2 currentTile) {

        List<Tile2> legalMoves = new ArrayList<>();

        int currentX = 0;
        int currentY = 0;

        for (int ix = 0; ix < gameBoard.length; ix++){
            for (int iy = 0; iy < gameBoard[ix].length; iy++){
                if (gameBoard[ix][iy] == currentTile){
                    currentX = ix;
                    currentY = iy;
                }
            }
        }

        for (int ix = 0; ix < gameBoard.length; ix++){
            for (int iy = 0; iy < gameBoard[ix].length; iy++){
                if ((currentX == ix && currentY != iy) || (currentX != ix && currentY == iy)){
                    legalMoves.add(gameBoard[ix][iy]);
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
