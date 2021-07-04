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
            super.setImage("/kingBlack.png");
        }else {
            super.setImage("/kingWhite.png");
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

        //Moves to the left
        if (currentX - 1 >= 0){
            if (!gameBoard[currentX - 1][currentY].isOccupied() || gameBoard[currentX - 1][currentY].getPiece().isWhite() != isWhite()){
                legalMoves.add(gameBoard[currentX - 1][currentY]);
            }
            if (currentY - 1 >= 0){
                if (!gameBoard[currentX - 1][currentY - 1].isOccupied() || gameBoard[currentX - 1][currentY - 1].getPiece().isWhite() != isWhite()){
                    legalMoves.add(gameBoard[currentX - 1][currentY - 1]);
                }
            }else {
                if (!gameBoard[currentX - 1][gameBoard[currentX].length - 1].isOccupied() || gameBoard[currentX-1][gameBoard[currentX].length - 1].getPiece().isWhite() != isWhite()){
                    legalMoves.add(gameBoard[currentX-1][gameBoard[currentX].length - 1]);
                }
            }
            if (currentY + 1 < gameBoard[currentX].length){
                if (!gameBoard[currentX - 1][currentY + 1].isOccupied() || gameBoard[currentX - 1][currentY + 1].getPiece().isWhite() != isWhite()){
                    legalMoves.add(gameBoard[currentX - 1][currentY + 1]);
                }
            }else {
                if (!gameBoard[currentX - 1][0].isOccupied() || gameBoard[currentX - 1][0].getPiece().isWhite() != isWhite()){
                    legalMoves.add(gameBoard[currentX - 1][0]);
                }
            }
        }

        //Straight up
        if (currentY - 1 > 0){
            if (!gameBoard[currentX][currentY - 1].isOccupied() || gameBoard[currentX][currentY - 1].getPiece().isWhite() != isWhite()){
                legalMoves.add(gameBoard[currentX][currentY - 1]);
            }
        }else {
            if (!gameBoard[currentX][gameBoard[currentX].length - 1].isOccupied() || gameBoard[currentX][gameBoard[currentX].length - 1].getPiece().isWhite() != isWhite()){
                legalMoves.add(gameBoard[currentX][gameBoard[currentX].length - 1]);
            }
        }

        //Straight down
        if (currentY + 1 < gameBoard[currentX].length){
            if (!gameBoard[currentX][currentY + 1].isOccupied() || gameBoard[currentX][currentY + 1].getPiece().isWhite() != isWhite()){
                legalMoves.add(gameBoard[currentX][currentY + 1]);
            }
        }else {
            if (!gameBoard[currentX][0].isOccupied() || gameBoard[currentX][0].getPiece().isWhite() != isWhite()){
                legalMoves.add(gameBoard[currentX][0]);
            }
        }

        //Moves to the right
        if (currentX + 1 < gameBoard.length){
            if (!gameBoard[currentX + 1][currentY].isOccupied() || gameBoard[currentX + 1][currentY].getPiece().isWhite() != isWhite()){
                legalMoves.add(gameBoard[currentX + 1][currentY]);
            }
            if (currentY - 1 >= 0){
                if (!gameBoard[currentX + 1][currentY - 1].isOccupied() || gameBoard[currentX + 1][currentY - 1].getPiece().isWhite() != isWhite()){
                    legalMoves.add(gameBoard[currentX + 1][currentY - 1]);
                }
            }else {
                if (!gameBoard[currentX + 1][gameBoard[currentX].length - 1].isOccupied() || gameBoard[currentX + 1][gameBoard[currentX].length - 1].getPiece().isWhite() != isWhite()){
                    legalMoves.add(gameBoard[currentX + 1][gameBoard[currentX].length - 1]);
                }
            }
            if (currentY + 1 < gameBoard[currentX].length){
                if (!gameBoard[currentX + 1][currentY + 1].isOccupied() || gameBoard[currentX + 1][currentY + 1].getPiece().isWhite() != isWhite()){
                    legalMoves.add(gameBoard[currentX + 1][currentY + 1]);
                }
            }else {
                if (!gameBoard[currentX + 1][0].isOccupied() || gameBoard[currentX + 1][0].getPiece().isWhite() != isWhite()){
                    legalMoves.add(gameBoard[currentX + 1][0]);
                }
            }
        }

        return legalMoves;
    }

    @Override
    public boolean isKing() {
        return isKing;
    }
}
