package chess.pieces;

import chess.position.Position;

public class Bishop extends Piece {
    public Bishop(String color, Position position) {
        super(color, position);
    }

    @Override
    public boolean isValidMove(Position newPosition, Piece[][] board) {
        int rowDiff = Math.abs(newPosition.getRow() - this.position.getRow());
        int colDiff = Math.abs(newPosition.getColumn() - this.position.getColumn());
        return rowDiff == colDiff;
    }

    @Override
    public String toString() {
        return color.equals("white") ? "wB" : "bB";
    }
}
