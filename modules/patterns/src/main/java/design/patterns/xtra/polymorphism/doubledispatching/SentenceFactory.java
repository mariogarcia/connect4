package design.patterns.xtra.polymorphism.doubledispatching;

final public class SentenceFactory implements PlayerVisitor<String> {
    private static SentenceFactory INSTANCE;
    private SentenceFactory() { }

    public static SentenceFactory getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SentenceFactory();
        }

        return INSTANCE;
    }

    public String getSentenceFrom(Player player) {
        return player.accepts(this);
    }

    @Override
    public String visit(AIPlayer aiPlayer) {
        return "kk";
    }

    @Override
    public String visit(HumanPlayer humanPlayer) {
        return "oo";
    }
}
