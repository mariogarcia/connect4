package connect4.controller

import connect4.model.Color
import connect4.model.Coordinate
import groovy.transform.InheritConstructors

@InheritConstructors
class PlayController extends Controller {

    void playWithCoordinate(Coordinate coordinate) {
        this.game.playWithCoordinate(coordinate)
    }

    void togglePlayer() {
        this.game.togglePlayer()
    }

    boolean isConnect4() {
        return this.game.isConnect4()
    }

    boolean isValidCoordinate(Coordinate coordinate) {
        return this.game.isValidCoordinate(coordinate)
    }

    Color getCurrentColor() {
        return this.game.currentColor
    }

    @Override
    void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this)
    }
}
