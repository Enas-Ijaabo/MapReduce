package writers;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;

public class CharListWriter {

    //writes output list size integer value, then write the list using BufferedOutputStream
    public static void write(DataOutputStream dataOutputStream, List<Character> output){
        try {
            int length= output.size();
            dataOutputStream.writeInt(length);
            dataOutputStream.flush();

            BufferedOutputStream bufferedOutputStream= new BufferedOutputStream(dataOutputStream);
            for (char c: output){
                bufferedOutputStream.write((int)c);
            }
            bufferedOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
