package readers;

import java.io.DataInputStream;
import java.util.ArrayList;
import java.util.List;

public class TextSplitReader {

    //read the text split from the input stream, and return it as a List<Character>
    public static List<Character> read(DataInputStream dataInputStream) {
        byte[] byteInput= readInputAsBytes(dataInputStream);
        List<Character> characterInput= turnByteArrayToCharacterList(byteInput);

        return characterInput;
    }

    //read text split as array of bytes
    private static byte[] readInputAsBytes(DataInputStream dataInputStream){
        return InputByteReader.read(dataInputStream);
    }

    //transform the array of bytes to List<Character>
    private static List<Character> turnByteArrayToCharacterList(byte[] byteInput){

        List<Character> characterInput= new ArrayList<Character>();
        for (byte byt: byteInput){
            characterInput.add((char) byt);
        }
        return characterInput;
    }

}
