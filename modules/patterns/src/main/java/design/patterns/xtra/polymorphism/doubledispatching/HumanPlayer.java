package design.patterns.xtra.polymorphism.doubledispatching;

public class HumanPlayer implements Player {
    @Override
    public <T> T accepts(PlayerVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
