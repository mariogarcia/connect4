package patterns.creational

import patterns.creational.prototype.Board
import patterns.creational.prototype.Coordinate
import patterns.creational.prototype.HumanPlayer
import patterns.creational.prototype.Player
import spock.lang.Specification

class PrototypeSpec extends Specification {
    def "check cloned boards don't share cells"() {
        given: "an initial board"
        Player player1 = new HumanPlayer();
        Player player2 = new HumanPlayer();
        Board board = new Board(3, 3)
                .addMove(player1, new Coordinate(0, 0))
                .addMove(player2, new Coordinate(0, 1))
                .addMove(player1, new Coordinate(1, 0));

        when: "cloning the board and adding a few more moves"
        Board clone = board
                .copy()
                .addMove(player1, new Coordinate(0, 2))
                .addMove(player2, new Coordinate(1, 1));

        then: "both boards should differ"
        board.filledCells.size() == 3
        clone.filledCells.size() == 5
    }

    def "check cloned boards don't share cells when resetting source"() {
        given: "an initial board"
        Player player1 = new HumanPlayer();
        Player player2 = new HumanPlayer();

        Board board = new Board(3, 3)
                .addMove(player1, new Coordinate(0, 0))
                .addMove(player2, new Coordinate(0, 1))
                .addMove(player1, new Coordinate(1, 0));

        when: "cloning the board and adding a few more moves"
        Board clone = board.copy()
            .addMove(player1, new Coordinate(0, 2))
            .addMove(player2, new Coordinate(1, 1));

        and: "resetting source board"
        board.reset()

        then: "both boards should differ"
        board.filledCells.size() == 0
        clone.filledCells.size() == 5
    }
}
