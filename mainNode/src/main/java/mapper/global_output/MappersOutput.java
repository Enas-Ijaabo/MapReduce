package mapper.global_output;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MappersOutput {

    private static MappersOutput mappersOutput;
    private static List<Map> mapperOutputList;

    //singleton design pattern
    private MappersOutput() {}

    //return the single instance of the MappersOutput
    public static MappersOutput getInstance(){
        if(mappersOutput== null){
            initialize();
        }
        return  mappersOutput;
    }

    //initialize the MappersOutput single instance and the list of output
    private static void initialize() {
        mappersOutput= new MappersOutput();
        mapperOutputList= new ArrayList<>();
    }

    //rest the singleton object
    public static void reset(){
        mappersOutput= new MappersOutput();
        mapperOutputList= new ArrayList<>();

    }

    //add map to mapperOutputList
    public void addMap(Map map){
        mapperOutputList.add(map);
    }

    public static List<Map> getMapperOutputList() {
        return mapperOutputList;
    }
}
