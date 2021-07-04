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
            super.setImage("/bishopBlack.png");
        }else {
            super.setImage("/bishopWhite.png");
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

        //DiagonalMoves
        boolean diagonalXPYPOccupied = false;
        int ix_D1 = currentX + 1;
        int iy_D1 = currentY + 1;
        while (ix_D1 < gameBoard.length && !diagonalXPYPOccupied){
            if (iy_D1 > gameBoard[currentX].length -1){
                iy_D1 = 0;
            }
            if (gameBoard[ix_D1][iy_D1].isOccupied()){
                diagonalXPYPOccupied = true;
                if (gameBoard[ix_D1][iy_D1].getPiece().isWhite() != gameBoard[currentX][currentY].getPiece().isWhite()){
                    legalMoves.add(gameBoard[ix_D1][iy_D1]);
                }
            } else {
                legalMoves.add(gameBoard[ix_D1][iy_D1]);
            }
            ix_D1++;
            iy_D1++;
            if (iy_D1 >= gameBoard[currentX].length -1){
                iy_D1 = 0;
            }
        }

        boolean diagonalXPYNOccupied = false;
        int ix_D2 = currentX + 1;
        int iy_D2 = currentY - 1;
        while (ix_D2 < gameBoard.length && !diagonalXPYNOccupied){
            if (iy_D2 < 0){
                iy_D2 = gameBoard[currentX].length - 1;
            }
            if (gameBoard[ix_D2][iy_D2].isOccupied()){
                diagonalXPYNOccupied = true;
                if (gameBoard[ix_D2][iy_D2].getPiece().isWhite() != gameBoard[currentX][currentY].getPiece().isWhite()){
                    legalMoves.add(gameBoard[ix_D2][iy_D2]);
                }
            } else {
                legalMoves.add(gameBoard[ix_D2][iy_D2]);
            }
            ix_D2++;
            iy_D2--;
            if (iy_D2 <= 0){
                iy_D2 = gameBoard[currentX].length - 1;
            }
        }

        boolean diagonalXNYPOccupied = false;
        int ix_D3 = currentX - 1;
        int iy_D3 = currentY + 1;
        while (ix_D3 >= 0 && !diagonalXNYPOccupied){
            if (iy_D3 > gameBoard[currentX].length -1){
                iy_D3 = 0;
            }
            if (gameBoard[ix_D3][iy_D3].isOccupied()){
                diagonalXNYPOccupied = true;
                if (gameBoard[ix_D3][iy_D3].getPiece().isWhite() != gameBoard[currentX][currentY].getPiece().isWhite()){
                    legalMoves.add(gameBoard[ix_D3][iy_D3]);
                }
            } else {
                legalMoves.add(gameBoard[ix_D3][iy_D3]);
            }
            ix_D3--;
            iy_D3++;
            if (iy_D3 >= gameBoard[currentX].length -1){
                iy_D3 = 0;
            }
        }

        boolean diagonalXNYNOccupied = false;
        int ix_D4 = currentX - 1;
        int iy_D4 = currentY - 1;
        while (ix_D4 >= 0 && !diagonalXNYNOccupied){
            if (iy_D4 < 0){
                iy_D4 = gameBoard[currentX].length - 1;
            }
            if (gameBoard[ix_D4][iy_D4].isOccupied()){
                diagonalXNYNOccupied = true;
                if (gameBoard[ix_D4][iy_D4].getPiece().isWhite() != gameBoard[currentX][currentY].getPiece().isWhite()){
                    legalMoves.add(gameBoard[ix_D4][iy_D4]);
                }
            } else {
                legalMoves.add(gameBoard[ix_D4][iy_D4]);
            }
            ix_D4--;
            iy_D4--;
            if (iy_D4 <= 0){
                iy_D4 = gameBoard[currentX].length - 1;
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
