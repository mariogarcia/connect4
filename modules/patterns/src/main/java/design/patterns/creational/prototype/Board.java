package design.patterns.creational.prototype;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Board implements CanBeCopied<Board> {
    private final List<Cell> cells;
    private final int rows, cols;

    public Board(int rows, int cols) {
        this.cells = new ArrayList<>();
        this.rows = rows;
        this.cols = cols;

        this.init();
    }

    private void init() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.cells.add(new Cell(new Coordinate(i, j)));
            }
        }
    }

    public Board addMove(Player player, Coordinate coordinate) {
        this.cells.stream()
            .filter(cell -> cell.getCoordinate().equals(coordinate))
            .findFirst()
            .ifPresent(cell -> cell.setPlayer(player));

        return this;
    }

    public void reset() {
        this.cells.forEach(Cell::reset);
    }

    public List<Cell> getFilledCells() {
        return this.cells.stream().filter(Cell::isNotEmpty).collect(Collectors.toList());
    }

    @Override
    public Board copy() {
        Board clonedBoard = new Board(this.rows, this.cols);
        this.cells
            .stream()
            .map(Cell::copy)
            .forEach(cell -> clonedBoard.addMove(cell.getPlayer(), cell.getCoordinate()));
        return clonedBoard;
    }
}
