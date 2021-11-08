package design.patterns.structural.adapter;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ThirdPartyReaderAdapter implements NumbersReader {
    private final ThirdPartyReader adaptee;

    public ThirdPartyReaderAdapter(File file) {
        this.adaptee = new ThirdPartyReader(file);
    }

    @Override
    public List<Integer> read() throws IOException {
        return this.adaptee.readLinesAsIntegers();
    }
}
