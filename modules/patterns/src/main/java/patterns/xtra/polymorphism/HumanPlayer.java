package patterns.xtra.polymorphism;

public class HumanPlayer implements Player {
    @Override
    public String visit(PlayerVisitor visitor) {
        return visitor.getSentence(this);
    }
}
