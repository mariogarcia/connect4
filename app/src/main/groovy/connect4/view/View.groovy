package connect4.view

import connect4.controller.GoodbyeController
import connect4.controller.PlayController
import connect4.controller.ResumeController
import connect4.controller.StartController

interface View {
    void start(StartController startController)
    void play(PlayController playController)
    void goodbye(GoodbyeController goodbyeController)
    boolean resume(ResumeController resumeController)
}