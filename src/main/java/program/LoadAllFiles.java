package program;

import casual.ConsoleOutput;
import classes.DataEflChaineDotLog;
import classes.Query;

import java.util.Map;

public class LoadAllFiles {

    public static void main(String[] args) throws InterruptedException {
        DataEflChaineDotLog data = new DataEflChaineDotLog();

        ConsoleOutput.write("Nombre d'évènements chargés: " + data.getData().size());

        Query query = new Query(data.getData());

        for(Map.Entry<String,Integer> e: query.getGroupOfPrograms().entrySet()) {
            ConsoleOutput.write(e.getKey() + " : " + e.getValue());
        }

        // 3174918 lignes : 1 949 120
        // 3174918 lignes : 3 587 120
        // 3174918 lignes : 2 332 216
        // 3174918 lignes : 3 024 124
    }
}
