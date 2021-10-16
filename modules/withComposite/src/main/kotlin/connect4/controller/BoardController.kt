package connect4.controller

import connect4.model.Color
import connect4.model.Game
import connect4.model.State

abstract class BoardController(private val game: Game, private val state: State): Controller(game, state) {
    fun getBoardSnapshot(): List<Array<Color>> {
        return this.game.getBoardSnapshot()
    }
}