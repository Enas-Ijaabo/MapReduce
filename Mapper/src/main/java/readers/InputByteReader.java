package readers;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class InputByteReader {

    //reads array length integer value, then reads an array of bytes using DataInputStream
    public static byte[] read(DataInputStream dataInputStream){

        int length= readLength(dataInputStream);
        byte[] byteInput= readBytes(length, dataInputStream);

        return byteInput;
    }

    private static int readLength(DataInputStream dataInputStream){
        int length=0;
        try {
            length= dataInputStream.readInt();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return length;
    }

    private static byte[] readBytes( int length, DataInputStream dataInputStream){
        byte[] byteInput = new byte[length];
        BufferedInputStream bufferedInputStream= new BufferedInputStream(dataInputStream);
        try {
            bufferedInputStream.read(byteInput);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteInput;
    }
}
