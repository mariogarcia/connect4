package patterns.xtra.polymorphism.doubledispatching;

public class Client {
    public static void main(String[] args) {
        Player aiPlayer = new AIPlayer();
        Player huPlayer = new HumanPlayer();

        SentenceFactory sentenceFactory = SentenceFactory.getInstance();

        System.out.println(sentenceFactory.getSentenceFrom(aiPlayer));
        System.out.println(sentenceFactory.getSentenceFrom(huPlayer));
    }
}
