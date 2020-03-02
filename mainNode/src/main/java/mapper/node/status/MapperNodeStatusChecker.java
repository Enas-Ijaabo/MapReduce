package mapper.node.status;

import java.io.IOException;
import java.io.ObjectInputStream;

public class MapperNodeStatusChecker {

    //checks if the mapper node is ready
    public static boolean isReady(ObjectInputStream objectInputStream){

        String mapperStatus= readStatus(objectInputStream);

        if (mapperStatus.equalsIgnoreCase("Mapper ready")){
            return true;
        }
        return false;
    }

    //read the mapperStatus
    private static String readStatus(ObjectInputStream objectInputStream){

        String mapperStatus="";
        try {
            mapperStatus =(String) objectInputStream.readObject();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return mapperStatus;
    }
}
