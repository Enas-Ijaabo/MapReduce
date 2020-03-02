package splitter;

import java.util.ArrayList;
import java.util.List;

public class TextSplits {

    private int numOfSplits;
    private int numberOfRetrievedSplits;
    private List<List<Character>> splits;

    public TextSplits(int numberOfNodes, List<List<Character>> splits) {
        this.numOfSplits = numberOfNodes;
        this.splits = splits;
    }

    //checks if there are any split that has not been retrieved
    public synchronized boolean hasNext(){
        if (numberOfRetrievedSplits >= numOfSplits){
            return false;
        }
        return true;
    }

    //returns the next split List<Character>
    public synchronized List<Character> getNextSplit() {
        if (!hasNext()){
            return new ArrayList<Character>();
        }
       List<Character> split= splits.get(numberOfRetrievedSplits);
        numberOfRetrievedSplits++;
        return split;
    }
}
