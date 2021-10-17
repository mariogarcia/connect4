package patterns.xtra.polymorphism.overwrite;

public class Client {
    public static void main(String[] args) {
        Player player1 = new AIPlayer();
        Player player2 = new HumanPlayer();
        SentenceFactory factory = SentenceFactory.getInstance();

        // In JAva this will always print the same output
        // In Groovy it will dispatch according to the runtime type
        // In Groovy statically typed behaves as Java does
        // In Kotlin behaves as Java does
        System.out.println(factory.getSentenceFrom(player1));
        System.out.println(factory.getSentenceFrom(player2));
    }
}
