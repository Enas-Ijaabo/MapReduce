package writers;

import java.io.DataOutputStream;
import java.io.IOException;

public class StringWriter {

    //writes output String size integer value, then write the list using DataInputStream
    public static void write(DataOutputStream dataOutputStream, String output){
        try {
            int length= output.length();
            dataOutputStream.writeInt(length);
            for (char c: output.toCharArray()){
                dataOutputStream.writeByte(c);
            }
            dataOutputStream.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
