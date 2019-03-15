package classes;

import casual.ConsoleOutput;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Event {

    String date;
    String context;
    String command;
    String parameters;
    String machine;
    String program;
    String commandDirectory;
    String env;

    public void setCommand(String command) {
        Pattern pattern = Pattern.compile("(.*)/(.*)$");

        Matcher m = pattern.matcher(command);

        if (m.matches()) {
            commandDirectory = m.group(1);
            program = m.group(2);

            pattern = Pattern.compile("(.*)-(.*)$");

            m = pattern.matcher(m.group(2));

            if (m.matches()) {
                program= m.group(1);
                env = m.group(2);
            }
        } else {
            program = command;
        }
        this.command = command;
    }

    public Event(String line) {
        String[] words = line.split("\\|");

        switch(words.length) {
            case 3 :
                date = words[0];
                context = words[1];
                setCommand(words[2]);
                break;
            case 4 :
                date = words[0];
                context = words[1];
                setCommand(words[2]);
                parameters = words[3];
                break;
            case 5 :
                machine = words[0];
                date = words[1];
                context = words[2];
                setCommand(words[3]);
                parameters = words[4];
                break;
            default :
                ConsoleOutput.writeWarning("Impossible de lire la ligne " + line);
        }

    }

    public String getProgram() {
        return program;
    }
}
