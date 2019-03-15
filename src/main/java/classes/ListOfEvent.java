package classes;

import casual.ConsoleOutput;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class ListOfEvent {

    List<Event> data = new ArrayList<Event>();

    public void addFile(Path path) {
        try {
            Stream<String> lines = Files.lines(path);
            lines.forEach(
                    new Consumer<String>() {
                        @Override
                        public void accept(String line) {
                            data.add(new Event(line));
                        }
                    }
            );
            lines.close();
        } catch (IOException e) {
            ConsoleOutput.writeWarning("through");
            e.printStackTrace();
            ConsoleOutput.stopOnError(e.getMessage());
        } catch (UncheckedIOException e) {
            ConsoleOutput.writeWarning(e.getMessage());
        }
    }

    public List getData() {
        return data;
   }


}
