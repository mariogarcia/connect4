package patterns.creational.prototype;

public class Coordinate implements CanBeCopied<Coordinate> {
    private final int row, col;

    public Coordinate(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public boolean equals(Object object) {
        if (!(object instanceof Coordinate)) {
            return false;
        }

        Coordinate other = (Coordinate) object;
        return this.row == other.row && this.col == other.col;
    }

    @Override
    public Coordinate copy() {
        return new Coordinate(this.row, this.col);
    }
}
