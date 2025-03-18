package LLD_JAVA.TicTacToe.api;

import LLD_JAVA.TicTacToe.TicTacToeGame;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Tictactoecontroller {
    @GetMapping("/tictactoe")
    public String tictactoe() {
        TicTacToeGame game = new TicTacToeGame();
        game.initializeGame();
        String winner = game.startGame();
        return "Game Over. Winner is: " + winner;
    }
}
