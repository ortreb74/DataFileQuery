package classes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Query {

    List<Event> data;

    public Query(List<Event> data) {
        this.data = data;
    }

    public Map<String,Integer> getGroupOfPrograms() {
        Map<String,Integer> result = new HashMap<String,Integer>();

        for (Event event : data) {
            if (result.containsKey(event.getProgram())) {
                String program = event.getProgram();
                result.put(program, result.get(program) + 1);
            } else {
                result.put(event.getProgram(), 1);
            }
        }

        return result;
    }
}
