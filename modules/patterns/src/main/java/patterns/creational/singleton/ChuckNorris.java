package patterns.creational.singleton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ChuckNorris {
    private static ChuckNorris INSTANCE;
    private final List<String> sentenceList = new ArrayList<>();

    private ChuckNorris() {
        sentenceList.add("Chuck Norris doesn’t read books. He stares them down until he gets the information he wants.");
        sentenceList.add("Time waits for no man. Unless that man is Chuck Norris.");
        sentenceList.add("If you spell Chuck Norris in Scrabble, you win. Forever.");
        sentenceList.add("Chuck Norris breathes air … five times a day.");
        sentenceList.add("In the Beginning there was nothing … then Chuck Norris roundhouse kicked nothing and told it to get a job.");
    }

    public String hasSomethingToSay() {
        Collections.shuffle(this.sentenceList);
        return this.sentenceList.get(0);
    }

    public static ChuckNorris getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ChuckNorris();
        }
        return INSTANCE;
    }
}
