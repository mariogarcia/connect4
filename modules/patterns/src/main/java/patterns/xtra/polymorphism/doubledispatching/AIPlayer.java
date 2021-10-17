package patterns.xtra.polymorphism.doubledispatching;

public class AIPlayer implements Player {

    @Override
    public String visit(PlayerVisitor visitor) {
        return visitor.getSentence(this);
    }
}
