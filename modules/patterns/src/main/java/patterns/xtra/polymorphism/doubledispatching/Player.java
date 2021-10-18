package patterns.xtra.polymorphism.doubledispatching;

public interface Player {
    <T> T accepts(PlayerVisitor<T> visitor);
}
