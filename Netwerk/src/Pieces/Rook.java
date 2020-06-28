package Pieces;

import Board.*;

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

        int currentX = 0;
        int currentY = 0;

        //Gets the X and Y coordinates for the tile the user selected
        for (int ix = 0; ix < gameBoard.length; ix++){
            for (int iy = 0; iy < gameBoard[ix].length; iy++){
                if (gameBoard[ix][iy] == currentTile){
                    currentX = ix;
                    currentY = iy;
                }
            }
        }

        //Vertical moves
        boolean verticalPositiveOccupied = false;
        for (int iy = currentY + 1; !verticalPositiveOccupied; iy++){
            if (iy >= gameBoard[currentX].length){
                iy=0;
            }
            if (gameBoard[currentX][iy].isOccupied()){
                verticalPositiveOccupied = true;
                if (gameBoard[currentX][iy].getPiece().isWhite() != gameBoard[currentX][currentY].getPiece().isWhite()){
                    legalMoves.add(gameBoard[currentX][iy]);
                }
            }else {
                legalMoves.add(gameBoard[currentX][iy]);
            }
        }

        boolean verticalNegativeOccupied = false;
        for (int iy = currentY - 1; !verticalNegativeOccupied; iy--){
            if (iy <= -1){
                iy = gameBoard[currentX].length -1;
            }
            if (gameBoard[currentX][iy].isOccupied()){
                verticalNegativeOccupied = true;
                if (gameBoard[currentX][iy].getPiece().isWhite() != gameBoard[currentX][currentY].getPiece().isWhite()){
                    legalMoves.add(gameBoard[currentX][iy]);
                }
            }else {
                legalMoves.add(gameBoard[currentX][iy]);
            }
        }

        //Horizontal moves
        boolean horizontalPositiveOccupied = false;
        for (int ix = currentX + 1; ix <= gameBoard.length-1 && !horizontalPositiveOccupied; ix++){
            if (gameBoard[ix][currentY].isOccupied()){
                horizontalPositiveOccupied = true;
                if (gameBoard[ix][currentY].getPiece().isWhite() != gameBoard[currentX][currentY].getPiece().isWhite()){
                    legalMoves.add(gameBoard[ix][currentY]);
                }
            }
            else {
                legalMoves.add(gameBoard[ix][currentY]);
            }
        }

        boolean horizontalNegativeOccupied = false;
        for (int ix = currentX - 1; ix >= 0 && !horizontalNegativeOccupied; ix--){
            if (gameBoard[ix][currentY].isOccupied()){
                horizontalNegativeOccupied = true;
                if (gameBoard[ix][currentY].getPiece().isWhite() != gameBoard[currentX][currentY].getPiece().isWhite()){
                    legalMoves.add(gameBoard[ix][currentY]);
                }
            }
            else {
                legalMoves.add(gameBoard[ix][currentY]);
            }
        }


        List<Tile2> cleanedLegalMoves = new ArrayList<>();
        for (Tile2 tile2 : legalMoves){
            if (!cleanedLegalMoves.contains(tile2)){
                cleanedLegalMoves.add(tile2);
            }
        }
        return cleanedLegalMoves;
    }

}
