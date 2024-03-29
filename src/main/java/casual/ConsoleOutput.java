package casual;

public class ConsoleOutput {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void stopOnError(String line) {
        writeError(line);
        System.exit(-1);
    }

    public static void writeError(String line) {
        write (ANSI_RED + line + ANSI_RESET);
    }

    public static void writeWarning(String line) {
        write (ANSI_YELLOW + line + ANSI_RESET);
    }

    public static void write(String line) {
        System.out.println(line);
    }


    public static void stopOnException(Exception e) {
        writeError(e.getMessage());
        e.printStackTrace();
        System.exit(-1);
    }

}
