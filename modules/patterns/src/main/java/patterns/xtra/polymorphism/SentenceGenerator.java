package patterns.xtra.polymorphism;

public interface SentenceGenerator {
    void accept(Player player);
    String generate();
}
