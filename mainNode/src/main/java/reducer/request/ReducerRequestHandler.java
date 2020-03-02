package reducer.request;

import reducer.global_output.ReducersOutput;
import reducer.node.status.ReducerNodeStatusChecker;
import reducer.reader.ReducerOutputReader;
import writers.MapWriter;
import writers.StringWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ReducerRequestHandler implements Runnable {

    private Socket socket;
    private Map reducerInput;
    private String reducerCode;

    public ReducerRequestHandler(Socket socket, Map reducerInput, String reducerCode) {
        this.socket = socket;
        this.reducerInput = reducerInput;
        this.reducerCode = reducerCode;
    }

    /* run map thread task:  check if reducer node is ready,
         send the input map to the node, send reducer code to the node,
         read the reduced output from the node, and save it in the ReducerOutput singleton object
         */
    @Override
    public void run() {

        if (!isReducerNodeReady()){
            return;
        }
        sendInputMap();
        sendReducerClass();
        Map output= readReducedOutput();
        saveOutputMap(output);
    }

    //check if reducer node is ready
    private boolean isReducerNodeReady() {

        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(socket.getInputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return ReducerNodeStatusChecker.isReady(objectInputStream);
    }

    //send the input map to the reducer node
    private void sendInputMap() {

        ObjectOutputStream objectOutputStream= null;
        try {
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        MapWriter.write(objectOutputStream, reducerInput);
    }

    //send reducer code to the node
    private void sendReducerClass() {
        DataOutputStream dataOutputStream= null;
        try {
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringWriter.write(dataOutputStream, reducerCode);
    }


    //read the reduced output from the node
    private Map readReducedOutput() {

        Map outputMap= new HashMap();
        try {
            ObjectInputStream objectInputStream= new ObjectInputStream(socket.getInputStream());
            outputMap= ReducerOutputReader.read(objectInputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return outputMap;
    }

    //save the reducer node output in the ReducersOutput singleton object
    private void saveOutputMap(Map outputMap){

        ReducersOutput reducersOutput = ReducersOutput.getInstance();
        reducersOutput.addMap(outputMap);
    }
}
