package design.patterns.creational.prototype;

public class HumanPlayer extends Player {
    @Override
    public boolean isHuman() {
        return true;
    }

    @Override
    public Player copy() {
        return new HumanPlayer();
    }
}
