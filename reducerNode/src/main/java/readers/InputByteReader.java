package readers;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class InputByteReader {

    //reads array length integer value, then reads an array of bytes using DataInputStream
    public static byte[] read(DataInputStream dataInputStream){
        byte[] byteInput=new byte[1];
        try {
            int length= dataInputStream.readInt();
            byteInput = new byte[length];
            BufferedInputStream bufferedInputStream= new BufferedInputStream(dataInputStream);
            bufferedInputStream.read(byteInput);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteInput;
    }
}
