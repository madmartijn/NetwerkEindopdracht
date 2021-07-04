package Pieces;

import Board.Tile2;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece{

    public Knight(boolean isWhite) {
        super(isWhite);

        if (!isWhite){
            super.setImage("/knightBlack.png");
        }else {
            super.setImage("/knightWhite.png");
        }
    }

    // calculates all legal moves for a knight to make.
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

        if (currentX - 2 >= 0){
            if (currentY - 1 == -1){
                if (!gameBoard[currentX - 2][gameBoard[currentX].length-1].isOccupied() || gameBoard[currentX - 2][gameBoard[currentX].length-1].getPiece().isWhite() != gameBoard[currentX][currentY].getPiece().isWhite()){
                    legalMoves.add(gameBoard[currentX - 2][gameBoard[currentX].length-1]);
                }
            }else {
                if (!gameBoard[currentX - 2][currentY - 1].isOccupied() || gameBoard[currentX - 2][currentY - 1].getPiece().isWhite() != gameBoard[currentX][currentY].getPiece().isWhite()){
                    legalMoves.add(gameBoard[currentX - 2][currentY - 1]);
                }
            }

            if (currentY + 1 == gameBoard[currentX].length){
                if (!gameBoard[currentX - 2][0].isOccupied() || gameBoard[currentX - 2][0].getPiece().isWhite() != gameBoard[currentX][currentY].getPiece().isWhite()){
                    legalMoves.add(gameBoard[currentX - 2][0]);
                }
            }else {
                if (!gameBoard[currentX - 2][currentY + 1].isOccupied() || gameBoard[currentX - 2][currentY + 1].getPiece().isWhite() != gameBoard[currentX][currentY].getPiece().isWhite()){
                    legalMoves.add(gameBoard[currentX - 2][currentY + 1]);
                }
            }
        }

        if (currentX - 1 >= 0){
            if (currentY - 2 < 0){
                if (!gameBoard[currentX - 1][gameBoard[currentX].length + currentY - 2].isOccupied() || gameBoard[currentX - 1][gameBoard[currentX].length + currentY - 2].getPiece().isWhite() != gameBoard[currentX][currentY].getPiece().isWhite()){
                    legalMoves.add(gameBoard[currentX - 1][gameBoard[currentX].length + currentY - 2]);
                }
            }else {
                if (!gameBoard[currentX - 1][currentY - 2].isOccupied() || gameBoard[currentX - 1][currentY - 2].getPiece().isWhite() != gameBoard[currentX][currentY].getPiece().isWhite()){
                    legalMoves.add(gameBoard[currentX - 1][currentY - 2]);
                }
            }
            if (currentY + 2 >= gameBoard[currentX].length){
                if (!gameBoard[currentX - 1][currentY + 2 - gameBoard[currentX].length].isOccupied() || gameBoard[currentX - 1][currentY + 2 - gameBoard[currentX].length].getPiece().isWhite() != gameBoard[currentX][currentY].getPiece().isWhite()){
                    legalMoves.add(gameBoard[currentX - 1][currentY + 2 - gameBoard[currentX].length]);
                }
            }else {
                if (!gameBoard[currentX - 1][currentY + 2].isOccupied() || gameBoard[currentX - 1][currentY + 2].getPiece().isWhite() != gameBoard[currentX][currentY].getPiece().isWhite()){
                    legalMoves.add(gameBoard[currentX - 1][currentY + 2]);
                }
            }
        }

        if (currentX + 2 < gameBoard.length){
            if (currentY + 1 == gameBoard[currentX].length) {
                if (!gameBoard[currentX + 2][0].isOccupied() || gameBoard[currentX + 2][0].getPiece().isWhite() != gameBoard[currentX][currentY].getPiece().isWhite()) {
                    legalMoves.add(gameBoard[currentX + 2][0]);
                }
            } else {
                if (!gameBoard[currentX + 2][currentY + 1].isOccupied() || gameBoard[currentX + 2][currentY + 1].getPiece().isWhite() != gameBoard[currentX][currentY].getPiece().isWhite()) {
                    legalMoves.add(gameBoard[currentX + 2][currentY + 1]);
                }
            }
            if (currentY - 1 == -1){
                if (!gameBoard[currentX + 2][gameBoard[currentX].length-1].isOccupied() || gameBoard[currentX + 2][gameBoard[currentX].length-1].getPiece().isWhite() != gameBoard[currentX][currentY].getPiece().isWhite()){
                    legalMoves.add(gameBoard[currentX + 2][gameBoard[currentX].length-1]);
                }
            }else {
                if (!gameBoard[currentX + 2][currentY - 1].isOccupied() || gameBoard[currentX + 2][currentY - 1].getPiece().isWhite() != gameBoard[currentX][currentY].getPiece().isWhite()){
                    legalMoves.add(gameBoard[currentX + 2][currentY - 1]);
                }
            }
        }

        if (currentX + 1 < gameBoard.length){
            if (currentY + 2 >= gameBoard[currentX].length){
                if (!gameBoard[currentX + 1][currentY + 2 - gameBoard[currentX].length].isOccupied() || gameBoard[currentX + 1][currentY + 2 - gameBoard[currentX].length].getPiece().isWhite() != gameBoard[currentX][currentY].getPiece().isWhite()){
                    legalMoves.add(gameBoard[currentX + 1][currentY + 2 - gameBoard[currentX].length]);
                }
            }else {
                if (!gameBoard[currentX + 1][currentY + 2].isOccupied() || gameBoard[currentX + 1][currentY + 2].getPiece().isWhite() != gameBoard[currentX][currentY].getPiece().isWhite()){
                    legalMoves.add(gameBoard[currentX + 1][currentY + 2]);
                }
            }
            if (currentY - 2 < 0){
                if (!gameBoard[currentX + 1][gameBoard[currentX].length + currentY - 2].isOccupied() || gameBoard[currentX + 1][gameBoard[currentX].length + currentY - 2].getPiece().isWhite() != gameBoard[currentX][currentY].getPiece().isWhite()){
                    legalMoves.add(gameBoard[currentX + 1][gameBoard[currentX].length + currentY - 2]);
                }
            }else {
                if (!gameBoard[currentX + 1][currentY - 2].isOccupied() || gameBoard[currentX + 1][currentY - 2].getPiece().isWhite() != gameBoard[currentX][currentY].getPiece().isWhite()){
                    legalMoves.add(gameBoard[currentX + 1][currentY - 2]);
                }
            }
        }



        return legalMoves;
    }

}
