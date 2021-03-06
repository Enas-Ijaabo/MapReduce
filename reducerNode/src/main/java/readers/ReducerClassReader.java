package readers;

import java.io.DataInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReducerClassReader {

    //read reducer class text from the input stream, and return it as a String
    public static String read(DataInputStream dataInputStream) {
        byte[] byteInput= readInputAsBytes(dataInputStream);
        String reducerClassText= turnByteArrayToString(byteInput);

        return reducerClassText;
    }

    //read reducer class text as array of bytes
    private static byte[] readInputAsBytes(DataInputStream dataInputStream){
      return InputByteReader.read(dataInputStream);
    }

    //transform the array of bytes to string
    private static String turnByteArrayToString(byte[] byteInput){

        List<Character> characterInput= new ArrayList<Character>();
        for (byte byt: byteInput){
            characterInput.add((char) byt);
        }
        return  characterInput.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}
