// src/chess/pieces/Pawn.java
package chess.pieces;

import chess.position.Position;

public class Pawn extends Piece {
    public Pawn(String color, Position position) {
        super(color, position);
    }

    @Override
    public boolean isValidMove(Position newPosition, Piece[][] board) {
        // Simple move validation for pawn (ignores captures and en passant)
        int rowDiff = newPosition.getRow() - this.position.getRow();
        int colDiff = Math.abs(newPosition.getColumn() - this.position.getColumn());
        if (this.color.equals("white")) {
            return rowDiff == 1 && colDiff == 0;
        } else {
            return rowDiff == -1 && colDiff == 0;
        }
    }

    @Override
    public String toString() {
        return color.equals("white") ? "wp" : "bp";
    }
}
