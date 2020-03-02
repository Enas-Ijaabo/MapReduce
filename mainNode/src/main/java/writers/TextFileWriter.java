package writers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TextFileWriter {

    //write a text on a file in certain path( filePath)
    public static void  write( String filePath, String text ){

        File file =new File(filePath);
        try {
            FileWriter fileWriter= new FileWriter(file);
            fileWriter.write(text);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
