package Pieces;

import Board.*;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece{

    private static int[] CANDIDATE_MOVE_COORDINATES = {7, 8, 9, 16};
    private boolean isBackLine;
    private boolean firsMove;

    public Pawn(boolean isWhite, boolean isBackLine) {
        super(isWhite);
        this.isBackLine = isBackLine;
        firsMove = true;

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

        int moveY = currentY;
        if ((!isWhite() && !isBackLine || (isWhite() && isBackLine))){
            if (moveY + 1 == gameBoard[currentX].length){
                moveY = -1;
            }

            if (!gameBoard[currentX][moveY + 1].isOccupied()){
                legalMoves.add(gameBoard[currentX][moveY + 1]);
            }
            if (currentX - 1 >= 0){
                if (gameBoard[currentX - 1][moveY + 1].isOccupied() && gameBoard[currentX - 1][moveY + 1].getPiece().isWhite() != isWhite()){
                    legalMoves.add(gameBoard[currentX - 1][moveY + 1]);
                }
            }
            if (currentX + 1 <gameBoard.length){
                if (gameBoard[currentX + 1][moveY + 1].isOccupied() && gameBoard[currentX + 1][moveY + 1].getPiece().isWhite() != isWhite()){
                    legalMoves.add(gameBoard[currentX + 1][moveY + 1]);
                }
            }
            if (firsMove){
                if (moveY + 2 == gameBoard[currentX].length){
                    moveY = -2;
                }
                if (!gameBoard[currentX][moveY + 2].isOccupied()){
                    legalMoves.add(gameBoard[currentX][moveY + 2]);
                    firsMove = false;
                }
            }
        }else if ((isWhite() && !isBackLine) || (!isWhite() && isBackLine)){
            if (moveY == 0){
                moveY = gameBoard[currentX].length;
            }

            if (!gameBoard[currentX][moveY - 1].isOccupied()){
                legalMoves.add(gameBoard[currentX][moveY - 1]);
            }
            if (currentX - 1 >= 0){
                if (gameBoard[currentX - 1][moveY - 1].isOccupied() && gameBoard[currentX - 1][moveY - 1].getPiece().isWhite() != isWhite()){
                    legalMoves.add(gameBoard[currentX - 1][moveY - 1]);
                }
            }
            if (currentX + 1 <gameBoard.length){
                if (gameBoard[currentX + 1][moveY - 1].isOccupied() && gameBoard[currentX + 1][moveY - 1].getPiece().isWhite() != isWhite()){
                    legalMoves.add(gameBoard[currentX + 1][moveY - 1]);
                }
            }
            if (firsMove){
                if (!gameBoard[currentX][moveY - 2].isOccupied()){
                    legalMoves.add(gameBoard[currentX][moveY - 2]);
                    firsMove = false;
                }
            }
        }


        return legalMoves;
    }
}
