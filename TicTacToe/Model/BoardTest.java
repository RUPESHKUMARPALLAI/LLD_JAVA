package LLD_JAVA.TicTacToe.Model;

import LLD_JAVA.TicTacToe.utils.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    private Board board;
    private PlayingPiece pieceX;
    private PlayingPiece pieceO;

    @BeforeEach
    public void setUp() {
        // Initialize the board and playing pieces
        board = new Board(3); // Create a 3x3 board
        pieceX = new PlayingPiece(PieceType.X); // Assuming PieceType.X exists in your code
        pieceO = new PlayingPiece(PieceType.O); // Assuming PieceType.O exists in your code
    }

    @Test
    public void testAddPieceToEmptyCell() {
        // Try adding a piece to an empty cell
        boolean result = board.addPiece(0, 0, pieceX);
        assertTrue(result, "Piece should be added successfully.");
        assertEquals(pieceX, board.board[0][0], "Cell should contain the added piece.");
    }

    @Test
    public void testAddPieceToOccupiedCell() {
        // First, add a piece to a cell
        board.addPiece(0, 0, pieceX);

        // Now try adding a different piece to the same cell
        boolean result = board.addPiece(0, 0, pieceO);
        assertFalse(result, "Piece should not be added to an occupied cell.");
    }

    @Test
    public void testGetFreeCells() {
        // Initially, all cells are free
        List<Pair<Integer, Integer>> freeCells = board.getFreeCells();
        assertEquals(9, freeCells.size(), "There should be 9 free cells initially.");

        // Add a piece to some cells
        board.addPiece(0, 0, pieceX);
        board.addPiece(1, 1, pieceO);

        // Now there should be 7 free cells
        freeCells = board.getFreeCells();
        assertEquals(7, freeCells.size(), "There should be 7 free cells after adding two pieces.");
    }

    @Test
    public void testPrintBoard() {
        // Add pieces and print the board
        board.addPiece(0, 0, pieceX);
        board.addPiece(1, 1, pieceO);
        // You can visually verify the printed output, or capture the output if needed.
        // Printing the board just to verify it doesn't throw any errors (though you'd likely manually verify the output):
        board.printBoard();
    }
}
