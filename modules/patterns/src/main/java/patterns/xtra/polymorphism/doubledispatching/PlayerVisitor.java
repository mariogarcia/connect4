package patterns.xtra.polymorphism.doubledispatching;

public interface PlayerVisitor {

    String getSentence(AIPlayer aiPlayer);
    String getSentence(HumanPlayer humanPlayer);
}
