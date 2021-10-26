package connect4.console.view

import connect4.common.view.ViewFactory

object ConsoleViewFactory: ViewFactory {
    override fun createStartView(): StartView = StartView()
    override fun createPlayerView(): PlayerView = PlayerView()
    override fun createResumeView(): ResumeView = ResumeView()
    override fun createBoardView(): BoardView = BoardView()
}