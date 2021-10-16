package connect4.controller

import connect4.model.Color
import connect4.model.Coordinate
import connect4.model.Player
import groovy.transform.InheritConstructors

@InheritConstructors class PlayController extends ControllerWithBoardSnapshot {
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

    Coordinate getRandomCoordinate() {
        List<Coordinate> coordinates = []

        this.boardSnapshot.eachWithIndex { Color[] rows, int row ->
            rows.eachWithIndex { Color entry, int col ->
                if (entry.isNull()) {
                    coordinates.add(new Coordinate(row, col))
                }
            }
        }

        return coordinates.shuffled().find()
    }

    Player getCurrentPlayer() {
        return this.game.currentPlayer
    }

    @Override
    void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this)
    }
}
