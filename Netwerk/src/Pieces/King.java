package Pieces;

import Board.*;

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

    @Override
    public boolean isKing() {
        return isKing;
    }
}
