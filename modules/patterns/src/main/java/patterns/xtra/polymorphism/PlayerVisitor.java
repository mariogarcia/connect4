package patterns.xtra.polymorphism;

public interface PlayerVisitor {

    String getSentence(AIPlayer aiPlayer);
    String getSentence(HumanPlayer humanPlayer);
}
