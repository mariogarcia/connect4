package patterns.creational.prototype;

public abstract class Player implements CanBeCopied<Player> {
    public abstract boolean isHuman();
}
