package design.patterns.xtra.polymorphism.overwrite;

public class SentenceFactory {
    private static SentenceFactory INSTANCE;

    private SentenceFactory() { }

    public static SentenceFactory getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SentenceFactory();
        }
        return INSTANCE;
    }

    String getSentenceFrom(AIPlayer aiPlayer) {
        return "IM A MACHINE";
    }

    String getSentenceFrom(HumanPlayer humanPlayer) {
        return "IM HUMAN";
    }
}
