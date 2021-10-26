package connect4.console.view

import connect4.common.model.Coordinate
import connect4.common.model.Player

class PlayerView {
    fun askForCoordinateToPlayer(player: Player): Coordinate {
        Console.writeLn("Now ${player.color} moves")
        return Console.askCoordinate(Messages.NEXT_MOVE_QUESTION.toString())
    }
}