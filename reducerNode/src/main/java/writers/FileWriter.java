package writers;

import java.io.File;
import java.io.IOException;

public class FileWriter {

    //create a file and write its content
    public static void writeFile( String filePath, String content){

        File file =new File(filePath);
        try {
            java.io.FileWriter fileWriter= new java.io.FileWriter(file);
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
