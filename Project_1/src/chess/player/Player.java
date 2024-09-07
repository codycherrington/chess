package chess.player;

import java.util.Scanner;

import chess.board.Board;
import chess.pieces.Piece;
import chess.position.Position;

public class Player {
    private String color;

    public Player(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void makeMove(Board board) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(color + "'s turn. Enter your move: ");
        String move = scanner.nextLine();
        String[] parts = move.split(" ");
        Position from = new Position(parts[0]);
        Position to = new Position(parts[1]);

        Piece piece = board.getPiece(from);
        if (piece != null && piece.getColor().equals(color) && piece.isValidMove(to, board.getBoard())) {
            board.movePiece(from, to);
        } else {
            System.out.println("Invalid move. Try again.");
        }
        
        //scanner.close();
    }
}
