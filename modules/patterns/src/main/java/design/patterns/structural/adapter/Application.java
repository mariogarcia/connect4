package design.patterns.structural.adapter;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Application {

    public void showLines() throws IOException {
        URL numbersFileURL = this.getClass().getResource("/numbers.txt");
        File file = new File(numbersFileURL.getFile());
        NumbersReader numbersReader = new ThirdPartyReaderAdapter(file);

        for (Integer i: numbersReader.read()) {
            System.out.println(i);
        }
    }
}
