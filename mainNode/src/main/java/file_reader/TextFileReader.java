package file_reader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TextFileReader implements FileReader<Character>{

    private File file;
    private BufferedReader bufferedReader;
    private List<Character> fileCharacters;

    public TextFileReader(File file) {

        this.file = file;
        fileCharacters= new ArrayList<Character>();

        try {
            bufferedReader = new BufferedReader(new java.io.FileReader(file));

        } catch (FileNotFoundException exception){

            System.err.println(" file not found Exception");
            System.out.println(exception.getMessage());
        }
    }

    //reads a text file and return its content in a List of Character
    public List<Character> readFile(){

        try {
            int character = bufferedReader.read();
            while (character!= -1){
                fileCharacters.add( (char)character);
                character= bufferedReader.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        closeResources();
        return fileCharacters;
    }

    //close the inputStream
    private void closeResources() {

        try {
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());;
        }
    }

    public List<Character> getFileCharacters() {
        return fileCharacters;
    }

}
