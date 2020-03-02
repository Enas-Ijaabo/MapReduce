package mapper.request;

import mapper.global_output.MappersOutput;
import mapper.node.status.MapperNodeStatusChecker;
import mapper.reader.MapperOutputReader;
import writers.CharListWriter;
import writers.StringWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapperRequestHandler implements Runnable {

    private Socket socket;
    private List<Character> split;
    private String mapperCode;

    public MapperRequestHandler(Socket socket, List<Character> split, String mapperCode) {
        this.socket = socket;
        this.split= split;
        this.mapperCode = mapperCode;
    }

    /* run map thread task:  check if mapper node is ready,
     send the input file split to the node, send mapper code to the node,
     read the mapping output from the node, and save it in the MappersOutput singleton object
     */
    @Override
    public void run() {

        if (!isMapperNodeReady()){
            return;
        }
        sendSplit();
        sendMapperClass();
        Map output= readMappingOutput();
        saveOutputMap(output);
    }

    //check if mapper node is ready
    private boolean isMapperNodeReady() {
        String mapperStatus = "";

        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(socket.getInputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return MapperNodeStatusChecker.isReady(objectInputStream);
    }

    //send the input file split to the mapper node
    private void sendSplit() {

        DataOutputStream dataOutputStream= null;
        try {
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        CharListWriter.write(dataOutputStream, split);
    }

    //send mapper code to the node
    private void sendMapperClass() {
        DataOutputStream dataOutputStream= null;
        try {
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringWriter.write(dataOutputStream, mapperCode);
    }


    //read the mapping output from the node
    private Map readMappingOutput() {

        Map outputMap= new HashMap();
        try {
            ObjectInputStream objectInputStream= new ObjectInputStream(socket.getInputStream());
            outputMap= MapperOutputReader.read(objectInputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return outputMap;
    }

    //save the mapper node output in the MappersOutput singleton object
    private void saveOutputMap(Map outputMap){

        MappersOutput mappersOutput= MappersOutput.getInstance();
        mappersOutput.addMap(outputMap);
    }
}
