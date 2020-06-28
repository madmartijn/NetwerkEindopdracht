package Pieces;

import Board.Tile2;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece{

    private static int[] CANDIDATE_MOVE_VECTOR = {-9, -7, 7, 9};

    public Bishop(boolean isWhite) {
        super(isWhite);

        if (!isWhite){
            try {
                super.setImage(ImageIO.read(this.getClass().getResourceAsStream("/bishopBlack.png")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            try {
                super.setImage(ImageIO.read(this.getClass().getResourceAsStream("/bishopWhite.png")));
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
}
