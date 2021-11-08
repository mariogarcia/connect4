package design.patterns.creational

import design.patterns.creational.prototype.Board
import design.patterns.creational.prototype.Coordinate
import design.patterns.creational.prototype.HumanPlayer
import design.patterns.creational.prototype.Player
import spock.lang.Specification

class PrototypeSpec extends Specification {
    def "check cloned boards don't share cells"() {
        given:
        def (player1, player2) = [new HumanPlayer()] * 2
        Board board = create3x3BoardWithPlayers(player1, player2)

        when:
        Board clone = board.copy()
            .addMove(player1, new Coordinate(0, 2))
            .addMove(player2, new Coordinate(1, 1));

        then:
        board.filledCells.size() == 3
        clone.filledCells.size() == 5
    }

    def "check cloned boards don't share cells when resetting source"() {
        given:
        def (player1, player2) = [new HumanPlayer()] * 2
        Board board = create3x3BoardWithPlayers(player1, player2)

        when:
        Board clone = board.copy()
            .addMove(player1, new Coordinate(0, 2))
            .addMove(player2, new Coordinate(1, 1));

        and:
        board.reset()

        then:
        board.filledCells.size() == 0
        clone.filledCells.size() == 5
    }

    private static Board create3x3BoardWithPlayers(Player player1, Player player2) {
        return new Board(3, 3)
            .addMove(player1, new Coordinate(0, 0))
            .addMove(player2, new Coordinate(0, 1))
            .addMove(player1, new Coordinate(1, 0));
    }
}
