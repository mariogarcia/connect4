package patterns.xtra.polymorphism;

final public class SentenceFactory implements PlayerVisitor{
    private static SentenceFactory INSTANCE;
    private SentenceFactory() { }

    public static SentenceFactory getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SentenceFactory();
        }

        return INSTANCE;
    }

    public String getSentenceFrom(Player player) {
        return player.visit(this);
    }

    public String getSentence(AIPlayer aiPlayer) {
        return "kk";
    }

    public String getSentence(HumanPlayer humanPlayer) {
        return "oo";
    }
}
