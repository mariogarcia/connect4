package connect4.console.controller

import connect4.common.model.Coordinate
import connect4.common.model.Session
import connect4.common.view.ViewFactory

class PlayController(private val session: Session, viewFactory: ViewFactory): Controller(session, viewFactory) {
    fun control() {
        do {
            showBoard()
            this.session.playWithCoordinate(this.getCoordinate())
        } while (!this.session.isConnect4())
    }

    private fun getCoordinate(): Coordinate {
        var coordinate: Coordinate
        val playerView = viewFactory.createPlayerView()
        val player = this.session.getCurrentPlayer()

        do {
            coordinate = playerView.askForCoordinateToPlayer(player)
        } while (!this.session.isValidCoordinate(coordinate))

        return coordinate
    }
}