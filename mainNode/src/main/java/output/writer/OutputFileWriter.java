package output.writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class OutputFileWriter {

    private String outputFilePath;
    private String outputFileName;
    private List<Map> reducersOutput;

    public OutputFileWriter(String outputFilePath, String outputFileName, List<Map> reducersOutput) {
        this.outputFilePath = outputFilePath;
        this.outputFileName = outputFileName;
        this.reducersOutput = reducersOutput;
    }

    //create and write the outputFile
    public void writeFile() {
        File file= new File(outputFilePath+"/"+outputFileName+".txt");
        String outputString= createOutputString();

        try(FileWriter fileWriter = new FileWriter(file)){
            writeOutput(fileWriter, outputString );

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //create an output String
    private String createOutputString() {

        StringBuilder stringBuilder= new StringBuilder();
        for (Map map: reducersOutput) {
            for (Object key : map.keySet()) {
                stringBuilder.append(key.toString() + ", " + map.get(key).toString() + "\n");
            }
        }
        return stringBuilder.toString();
    }

    //write the output on file
    private void writeOutput(FileWriter fileWriter, String output) {

        try {
            fileWriter.write(output);
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
