package design.patterns.xtra.polymorphism.overwrite;

public class Client {
    public static void main(String[] args) {
        AIPlayer player1 = new AIPlayer();
        HumanPlayer player2 = new HumanPlayer();
        SentenceFactory factory = SentenceFactory.getInstance();

        System.out.println(factory.getSentenceFrom(player1));
        System.out.println(factory.getSentenceFrom(player2));
    }
}
