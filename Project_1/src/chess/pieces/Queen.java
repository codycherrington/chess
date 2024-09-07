package chess.pieces;

import chess.position.Position;

public class Queen extends Piece {
    public Queen(String color, Position position) {
        super(color, position);
    }

    @Override
    public boolean isValidMove(Position newPosition, Piece[][] board) {
        int rowDiff = Math.abs(newPosition.getRow() - this.position.getRow());
        int colDiff = Math.abs(newPosition.getColumn() - this.position.getColumn());
        return rowDiff == colDiff || rowDiff == 0 || colDiff == 0;
    }

    @Override
    public String toString() {
        return color.equals("white") ? "wQ" : "bQ";
    }
}
