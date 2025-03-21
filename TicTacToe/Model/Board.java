package LLD_JAVA.TicTacToe.Model;

import java.util.List;
import java.util.ArrayList;
import LLD_JAVA.TicTacToe.utils.Pair;


public class Board {
    public int size;
    public PlayingPiece[][] board;

    public Board(int size) {
        this.size = size;
        board = new PlayingPiece[size][size];
    }


    public boolean addPiece(int row, int column, PlayingPiece playingPiece) {
        try {
            if (board[row][column] != null) {
                return false; // Cell already occupied
            }
            board[row][column] = playingPiece;
            return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid position: (" + row + ", " + column + "). Please enter values within board limits.");
            return false;
        }
    }

    public List<Pair<Integer, Integer>> getFreeCells() {
        List<Pair<Integer, Integer>> freeCells = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == null) {
                    Pair<Integer, Integer> rowColumn = new Pair<>(i, j);
                    freeCells.add(rowColumn);
                }
            }
        }

        return freeCells;
    }

    public void printBoard() {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] != null) {
                    System.out.print(board[i][j].pieceType.name() + "   ");
                } else {
                    System.out.print("    ");

                }
                System.out.print(" | ");
            }
            System.out.println();

        }
    }
}