package reducer.global_output;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReducersOutput {

    private static ReducersOutput reducersOutput;
    private static List<Map> reducersOutputList;

    //singleton design pattern
    private ReducersOutput() {}

    //return the single instance of the ReducersOutput
    public static ReducersOutput getInstance(){
        if(reducersOutput == null){
            initialize();
        }
        return reducersOutput;
    }

    //initialize the ReducersOutput single instance and the list of output
    private static void initialize() {
        reducersOutput = new ReducersOutput();
        reducersOutputList = new ArrayList<>();
    }

    //rest the singleton object
    public static void reset(){
        reducersOutput = new ReducersOutput();
        reducersOutputList = new ArrayList<>();

    }

    //add map to reducersOutputList
    public void addMap(Map map){
        reducersOutputList.add(map);
    }

    public static List<Map> getReducersOutputList() {
        return reducersOutputList;
    }
}
