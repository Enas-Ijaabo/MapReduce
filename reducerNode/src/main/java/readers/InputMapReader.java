package readers;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InputMapReader {

    //read the the inputMap from the input stream
    public static Map<Object, List> read(ObjectInputStream objectInputStream) {
        Map<Object, List> map= null;
        try {
            map = (Map) objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return map;
    }

}
