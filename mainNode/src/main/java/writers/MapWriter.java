package writers;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;

public class MapWriter {

    //write the Map object using ObjectOutputStream
    public static void write(ObjectOutputStream objectOutputStream, Map output){
        try {
           objectOutputStream.writeObject(output);
           objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
