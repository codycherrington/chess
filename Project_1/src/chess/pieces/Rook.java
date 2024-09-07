package chess.pieces;

import chess.position.Position;

public class Rook extends Piece {
    public Rook(String color, Position position) {
        super(color, position);
    }

    @Override
    public boolean isValidMove(Position newPosition, Piece[][] board) {
        int rowDiff = newPosition.getRow() - this.position.getRow();
        int colDiff = newPosition.getColumn() - this.position.getColumn();
        return (rowDiff == 0 || colDiff == 0);
    }

    @Override
    public String toString() {
        return color.equals("white") ? "wR" : "bR";
    }
}
