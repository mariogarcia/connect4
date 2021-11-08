package design.patterns.xtra.polymorphism.doubledispatching;

public class AIPlayer implements Player {
    @Override
    public <T> T accepts(PlayerVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
