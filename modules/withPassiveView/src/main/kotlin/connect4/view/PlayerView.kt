package connect4.view

import connect4.model.Coordinate
import connect4.model.Player

class PlayerView {
    fun askForCoordinateToPlayer(player: Player): Coordinate {
        Console.writeLn("Now ${player.color} moves")
        return Console.askCoordinate(Messages.NEXT_MOVE_QUESTION.toString())
    }
}