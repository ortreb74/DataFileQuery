package classes;

import casual.ConsoleOutput;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class DataEflChaineDotLog {

    static String cSourceDirectory = "c:/data/chaine.log";

    ListOfEvent listOfEvent = new ListOfEvent();

    public DataEflChaineDotLog() {
        // en fait il y a une question de contexte

        try {
            DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(cSourceDirectory),"*.log");

            stream.forEach(
                new Consumer<Path>() {
                    @Override
                    public void accept(Path path) {
                        ConsoleOutput.write(path.toString());
                        listOfEvent.addFile(path);
                    }
                }
            );

            stream.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public List getData() {
        return listOfEvent.getData();
    }


}
