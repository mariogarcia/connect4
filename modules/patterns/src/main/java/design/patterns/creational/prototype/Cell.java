package design.patterns.creational.prototype;

public class Cell implements CanBeCopied<Cell> {
    private Player player;
    private final Coordinate coordinate;

    public Cell(Coordinate coordinate) {
        this.player = new NullPlayer();
        this.coordinate = coordinate;
    }

    public void reset() {
        this.player = new NullPlayer();
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Coordinate getCoordinate() {
        return this.coordinate;
    }

    public Player getPlayer() {
        return this.player;
    }

    public boolean isEmpty() {
        return !this.isNotEmpty();
    }

    public boolean isNotEmpty() {
        return this.player.isHuman();
    }

    public Cell copy() {
        Cell cell = new Cell(this.coordinate.copy());
        cell.setPlayer(this.player.copy());
        return cell;
    }
}
