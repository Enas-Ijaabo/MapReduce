package splitter;

import file_reader.TextFileReader;

import java.io.File;
import java.util.List;

public class SplitTaskStarter {

    private int numOfMapperNodes;
    private String filePath;

    public SplitTaskStarter(int numOfMapperNodes, String filePath) {
        this.numOfMapperNodes = numOfMapperNodes;
        this.filePath= filePath;
    }

    /*reads the input text file, split it to equal List<Character>
     and save those lists in TextSplits Object */
    public TextSplits startSplittingTask(){
        List<Character> fileText= readFile();
        TextSplitter textSplitter= new TextSplitter(numOfMapperNodes, fileText );
        List<List<Character>> splitsList= textSplitter.splitText();
        TextSplits textSplits= new TextSplits(numOfMapperNodes, splitsList );

        return textSplits;
    }

    private List<Character> readFile() {
        File file= new File(filePath);
        TextFileReader textFileReader= new TextFileReader(file);
        return textFileReader.readFile();
    }
}
