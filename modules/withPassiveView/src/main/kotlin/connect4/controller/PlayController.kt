package connect4.controller

import connect4.model.Coordinate
import connect4.model.Session
import connect4.view.ViewFactory

class PlayController(private val session: Session): Controller(session) {
    fun control() {
        do {
            showBoard()
            this.session.playWithCoordinate(this.getCoordinate())
        } while (!this.session.isConnect4())
    }

    private fun getCoordinate(): Coordinate {
        var coordinate: Coordinate
        val playerView = ViewFactory.createPlayerView()
        val player = this.session.getCurrentPlayer()

        do {
            coordinate = playerView.askForCoordinateToPlayer(player)
        } while (!this.session.isValidCoordinate(coordinate))

        return coordinate
    }
}