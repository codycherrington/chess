package chess.board;

import chess.pieces.*;
import chess.position.Position;

public class Board {
    private Piece[][] board;

    public Board() {
        board = new Piece[8][8];
        initializeBoard();
    }

    private void initializeBoard() {
        // Initialize black pieces
        board[0][0] = new Rook("black", new Position(0, 0));
        board[0][1] = new Knight("black", new Position(0, 1));
        board[0][2] = new Bishop("black", new Position(0, 2));
        board[0][3] = new Queen("black", new Position(0, 3));
        board[0][4] = new King("black", new Position(0, 4));
        board[0][5] = new Bishop("black", new Position(0, 5));
        board[0][6] = new Knight("black", new Position(0, 6));
        board[0][7] = new Rook("black", new Position(0, 7));
        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn("black", new Position(1, i));
        }

        // Initialize white pieces
        board[7][0] = new Rook("white", new Position(7, 0));
        board[7][1] = new Knight("white", new Position(7, 1));
        board[7][2] = new Bishop("white", new Position(7, 2));
        board[7][3] = new Queen("white", new Position(7, 3));
        board[7][4] = new King("white", new Position(7, 4));
        board[7][5] = new Bishop("white", new Position(7, 5));
        board[7][6] = new Knight("white", new Position(7, 6));
        board[7][7] = new Rook("white", new Position(7, 7));
        for (int i = 0; i < 8; i++) {
            board[6][i] = new Pawn("white", new Position(6, i));
        }
    }

    public Piece getPiece(Position position) {
        return board[position.getRow()][position.getColumn()];
    }

    public void movePiece(Position from, Position to) {
        Piece piece = board[from.getRow()][from.getColumn()];
        board[to.getRow()][to.getColumn()] = piece;
        board[from.getRow()][from.getColumn()] = null;
        piece.setPosition(to);
    }

    public Piece[][] getBoard() {
        return board;
    }

    public void display() {
        for (int i = 7; i >= 0; i--) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == null) {
                    if ((i + j) % 2 == 0) {
                        System.out.print("## ");
                    } else {
                        System.out.print("   ");
                    }
                } else {
                    System.out.print(board[i][j] + " ");
                }
            }
            System.out.println();
        }
        System.out.println("  A  B  C  D  E  F  G  H");
    }

    public boolean isKingInCheck(String color) {
        Position kingPosition = findKingPosition(color);
        if (kingPosition == null) {
            return false;
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece piece = board[i][j];
                if (piece != null && !piece.getColor().equals(color) && piece.isValidMove(kingPosition, board)) {
                    return true;
                }
            }
        }
        return false;
    }

    private Position findKingPosition(String color) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece piece = board[i][j];
                if (piece instanceof King && piece.getColor().equals(color)) {
                    return piece.getPosition();
                }
            }
        }
        return null;
    }

    public boolean wouldBeInCheckAfterMove(Position from, Position to, String color) {
        Piece piece = getPiece(from);
        Piece targetPiece = getPiece(to);
        movePiece(from, to);
        boolean inCheck = isKingInCheck(color);
        movePiece(to, from);
        board[to.getRow()][to.getColumn()] = targetPiece;
        return inCheck;
    }
}