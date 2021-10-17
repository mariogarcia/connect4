package patterns.xtra.polymorphism.doubledispatching;

public class HumanPlayer implements Player {
    @Override
    public String visit(PlayerVisitor visitor) {
        return visitor.getSentence(this);
    }
}
