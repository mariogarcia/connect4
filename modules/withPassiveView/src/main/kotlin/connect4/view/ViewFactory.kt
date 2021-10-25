package connect4.view

object ViewFactory {

    fun createStartView(): StartView {
        return StartView()
    }

    fun createPlayerView(): PlayerView {
        return PlayerView()
    }

    fun createResumeView(): ResumeView {
        return ResumeView()
    }

    fun createBoardView(): BoardView {
        return BoardView()
    }
}