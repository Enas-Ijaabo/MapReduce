package reduce.handler;

import reducer.ReducerClassText;
import readers.InputMapReader;
import readers.ReducerClassReader;
import reducer.runner.ReduceRunner;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Map;

public class MainNodeResponseHandler {

    Map<Object, List> inputMap;
    ObjectInputStream objectInputStream;
    DataInputStream dataInputStream;
    ObjectOutputStream objectOutputStream;
    ReducerClassText reducerClassText;

    public MainNodeResponseHandler(DataInputStream dataInputStream, ObjectOutputStream objectOutputStream
            , ObjectInputStream objectInputStream) {
        this.dataInputStream = dataInputStream;
        this.objectOutputStream= objectOutputStream;
        this.objectInputStream= objectInputStream;

    }

    /*handel reducing request: 1-read the input map , 2-read Reducer class
     3-execute reducing and get the result, 4- send the result
     */
    public void handleResponse(){

        readInputMap();
        readReducerClass();
        Map reducerOutput = runReducer();
        sendReducerResult(reducerOutput);
    }

    //read the input map input from the objectInputStream
    private void readInputMap() {

        inputMap= InputMapReader.read(objectInputStream);
    }

    //read reducer class Input as a String
    private void readReducerClass() {

        String reducerClass= ReducerClassReader.read(dataInputStream);
        reducerClassText = new ReducerClassText( reducerClass);
    }

    //Run the reduce function on inputMap and return the result as a reduced Map
    private Map runReducer() {

        ReduceRunner reduceRunner = new ReduceRunner(inputMap , reducerClassText);

        Map reducerOutput = reduceRunner.runReducer();
        return reducerOutput;
    }

    //send the reducing result as a Map, using ObjectOutputStream
    private void sendReducerResult(Map reducerOutput) {
      try {
          objectOutputStream.writeObject(reducerOutput);
          objectOutputStream.flush();
      } catch (IOException e) {
          e.printStackTrace();
      }
    }
}
