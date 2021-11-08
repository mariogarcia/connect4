package design.patterns.xtra.polymorphism.doubledispatching;

public interface PlayerVisitor<T> {
    T visit(AIPlayer aiPlayer);
    T visit(HumanPlayer humanPlayer);
}
