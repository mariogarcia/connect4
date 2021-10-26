package connect4.common.view

import connect4.console.view.BoardView
import connect4.console.view.PlayerView
import connect4.console.view.ResumeView
import connect4.console.view.StartView

interface ViewFactory {
    fun createStartView(): StartView
    fun createPlayerView(): PlayerView
    fun createResumeView(): ResumeView
    fun createBoardView(): BoardView
}