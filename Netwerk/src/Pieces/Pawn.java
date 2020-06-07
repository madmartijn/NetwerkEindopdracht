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
    public List<Tile2> PossibleMoves(Tile2[][] gameBoard, Tile2 currentTile) {
        List<Tile2> legalMoves = new ArrayList<>();


        return legalMoves;
    }
}
