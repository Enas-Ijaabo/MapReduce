package reducer.node.status;

import java.io.IOException;
import java.io.ObjectInputStream;

public class ReducerNodeStatusChecker {

    //checks if the reducer node is ready
    public static boolean isReady(ObjectInputStream objectInputStream){

        String mapperStatus= readStatus(objectInputStream);

        if (mapperStatus.equalsIgnoreCase("Reducer ready")){
            return true;
        }
        return false;
    }

    //read the reducerStatus
    private static String readStatus(ObjectInputStream objectInputStream){

        String reducerStatus="";
        try {
            reducerStatus =(String) objectInputStream.readObject();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return reducerStatus;
    }
}
