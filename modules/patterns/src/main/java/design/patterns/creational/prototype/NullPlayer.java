package design.patterns.creational.prototype;

public class NullPlayer extends Player {
    @Override
    public boolean isHuman() {
        return false;
    }

    @Override
    public NullPlayer copy() {
        return new NullPlayer();
    }
}
