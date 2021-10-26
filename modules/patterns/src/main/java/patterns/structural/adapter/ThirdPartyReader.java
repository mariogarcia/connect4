package patterns.structural.adapter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

public class ThirdPartyReader {
    private final File file;
    public ThirdPartyReader(File file) {
        this.file = file;
    }

    public List<Integer> readLinesAsIntegers() throws IOException {
        return Files.readAllLines(this.file.toPath())
            .stream()
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }
}
