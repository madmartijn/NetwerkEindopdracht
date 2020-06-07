package Pieces;

import Board.*;
import Board.Move.*;
import Board.Tile.Tile2;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece{

    private static int[] CANDIDATE_MOVE_VECTOR = {-8, -1, 1, 8};


    public Rook(boolean isWhite) {
        super(isWhite);

        if (!isWhite){
            try {
                super.setImage(ImageIO.read(this.getClass().getResourceAsStream("/rookBlack.png")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            try {
                super.setImage(ImageIO.read(this.getClass().getResourceAsStream("/rookWhite.png")));
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


    private static boolean isFirstColumnExclusion(int currentPosition, int candidateOffset){
        return BoardUtils.FIRST_COLUMN[currentPosition] && (candidateOffset == -1);
    }

    private static boolean isEightColumnExclusion(int currentPosition, int candidateOffset){
        return BoardUtils.EIGHT_COLUMN[currentPosition] && (candidateOffset == 1);
    }
}
