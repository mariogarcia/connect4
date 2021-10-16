package connect4

import connect4.model.Board
import connect4.model.BoardBuilder
import connect4.model.Color
import connect4.model.Coordinate
import connect4.model.HumanPlayer
import connect4.model.Player
import spock.lang.Shared
import spock.lang.Specification

class Connect4Test extends Specification {
    static final Player HUMAN_PLAYER = new HumanPlayer(Color.BLACK)
    @Shared Board board

    def setup() {
        board = new BoardBuilder()
            .withRows(7)
            .withColumns(6)
            .withRequiredWinningMoves(4)
            .build()
    }

    def "check win in row"() {
        setup: "a winning horizontal sequence"
        def board = board
            .fillCell(HUMAN_PLAYER, new Coordinate(0, 0))
            .fillCell(HUMAN_PLAYER, new Coordinate(0, 1))
            .fillCell(HUMAN_PLAYER, new Coordinate(0, 2))
            .fillCell(HUMAN_PLAYER, new Coordinate(0, 3))

        expect: "is a win"
        board.isConnect4()
    }

    def "check win in column"() {
        setup: "a winning vertical sequence"
        def board = board
            .fillCell(HUMAN_PLAYER, new Coordinate(1, 0))
            .fillCell(HUMAN_PLAYER, new Coordinate(2, 0))
            .fillCell(HUMAN_PLAYER, new Coordinate(3, 0))
            .fillCell(HUMAN_PLAYER, new Coordinate(4, 0))

        expect: "is a win"
        board.isConnect4()
    }

    def "check win in main diagonal"() {
        setup: "a winning in the main diagonal"
        def board = board
            .fillCell(HUMAN_PLAYER, new Coordinate(0, 0))
            .fillCell(HUMAN_PLAYER, new Coordinate(1, 1))
            .fillCell(HUMAN_PLAYER, new Coordinate(2, 2))
            .fillCell(HUMAN_PLAYER, new Coordinate(3, 3))

        expect: "is a win"
        board.isConnect4()
    }

    def "check win in inverse diagonal"() {
        setup: "a winning in the inverse diagonal"
        def board = board
            .fillCell(HUMAN_PLAYER, new Coordinate(1, 3))
            .fillCell(HUMAN_PLAYER, new Coordinate(2, 2))
            .fillCell(HUMAN_PLAYER, new Coordinate(3, 1))
            .fillCell(HUMAN_PLAYER, new Coordinate(4, 0))

        expect: "is a win"
        board.isConnect4()
    }
}