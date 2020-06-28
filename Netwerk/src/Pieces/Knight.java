package Pieces;

import Board.Tile2;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece{

    private final static int[] POSSIBLE_MOVES = {-17, -15, -10, -6, 6, 10, 15, 17};

    public Knight(boolean isWhite) {
        super(isWhite);

        if (!isWhite){
            try {
                super.setImage(ImageIO.read(this.getClass().getResourceAsStream("/knightBlack.png")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            try {
                super.setImage(ImageIO.read(this.getClass().getResourceAsStream("/knightWhite.png")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // calculates all legal moves for a knight to make.
    @Override
    public List<Tile2> PossibleMoves(Tile2[][] gameBoard, Tile2 currentTile) {
        List<Tile2> legalMoves = new ArrayList<>();


        return legalMoves;
    }

}
