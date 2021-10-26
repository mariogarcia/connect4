package patterns.structural.adapter;

import java.io.IOException;
import java.util.List;

public interface NumbersReader {
    List<Integer> read() throws IOException;
}
