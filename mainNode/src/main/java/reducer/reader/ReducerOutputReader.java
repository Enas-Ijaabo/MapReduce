package reducer.reader;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;

public class ReducerOutputReader {

    //read the Map output from a reducer node using objectInputStream
    public static Map read(ObjectInputStream objectInputStream){

        try {
           return (Map) objectInputStream.readObject();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return new HashMap();
    }
}
