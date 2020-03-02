package map.handler;

import mapper.MapperClassText;
import mapper.runner.MapRunner;
import readers.MapperClassReader;
import readers.TextSplitReader;
import text.TextSplit;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Map;

public class MainNodeResponseHandler {

    DataInputStream dataInputStream;
    ObjectOutputStream objectOutputStream;
    TextSplit textSplit;
    MapperClassText mapperClassText;

    public MainNodeResponseHandler(DataInputStream dataInputStream, ObjectOutputStream objectOutputStream) {
        this.dataInputStream = dataInputStream;
        this.objectOutputStream= objectOutputStream;
    }

    /*handel mapping request: 1-read the text, 2-read Mapper class
     3-execute mapping and get the result, 4- send the result
     */
    public void handleResponse(){

        readTextSplit();
        readMapperClass();
        Map mapperOutput = runMapper();
        sendMappedResult(mapperOutput);

    }

    //read the text split input as a List<Character>
    private void readTextSplit() {

        List<Character> characterInput= TextSplitReader.read(dataInputStream);
        textSplit= new TextSplit(characterInput);
    }

    //read Mapper class Input as a String
    private void readMapperClass() {

        String mapperClass= MapperClassReader.read(dataInputStream);
        mapperClassText= new MapperClassText( mapperClass);
    }

    //Run the mapping function of the text split and return the result as a Map
    private Map runMapper() {

        MapRunner mapRunner = new MapRunner(textSplit, mapperClassText);

        Map mapperOutput = mapRunner.runMapper();
        return mapperOutput;
    }

    //send the mapping result as a Map, using ObjectOutputStream
    private void sendMappedResult(Map mapperOutput) {
      try {
          objectOutputStream.writeObject(mapperOutput);
          objectOutputStream.flush();
      } catch (IOException e) {
          e.printStackTrace();
      }
    }
}
