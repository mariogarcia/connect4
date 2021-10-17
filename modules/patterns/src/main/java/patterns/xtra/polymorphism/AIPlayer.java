package patterns.xtra.polymorphism;

public class AIPlayer implements Player {

    @Override
    public String visit(PlayerVisitor visitor) {
        return visitor.getSentence(this);
    }
}
