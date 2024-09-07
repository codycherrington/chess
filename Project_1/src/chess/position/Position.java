package chess.position;

public class Position {
    private int row;
    private int column;

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public Position(String position) {
        this.column = position.charAt(0) - 'A';
        this.row = position.charAt(1) - '1';
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    @Override
    public String toString() {
        return "" + (char) (column + 'A') + (row + 1);
    }
}
