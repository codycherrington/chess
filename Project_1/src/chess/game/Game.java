package chess.game;

import chess.board.Board;
import chess.player.Player;

public class Game {
    private Board board;
    private Player whitePlayer;
    private Player blackPlayer;
    private Player currentPlayer;

    public Game() {
        board = new Board();
        whitePlayer = new Player("white");
        blackPlayer = new Player("black");
        currentPlayer = whitePlayer;
    }

    public void start() {
        while (true) {
            board.display();
            currentPlayer.makeMove(board);
            currentPlayer = (currentPlayer == whitePlayer) ? blackPlayer : whitePlayer;
        }
    }

    public static void main(String[] args) {
        Game game = new Game();

    }
    
}


