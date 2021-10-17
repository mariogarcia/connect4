package patterns.xtra.polymorphism.doubledispatching;

public interface SentenceGenerator {
    void accept(Player player);
    String generate();
}
