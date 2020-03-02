package splitter;

import java.util.ArrayList;
import java.util.List;

public class TextSplitter {

    private int numOfSplits;
    private List<Character> fileContent;
    private int startingIndex;

    public TextSplitter(int numberOfNodes, List<Character> fileContent) {
        this.numOfSplits = numberOfNodes;
        this.fileContent = fileContent;
        startingIndex=0;
    }

    //split text into lists of Characters of equal sizes, and return those subLists in a List
    public List<List<Character>> splitText() {

        List<List<Character>> splitList;

        boolean isEven= fileContent.size()%2==0;
        if (isEven){
            splitList= evenSplit();
        }else {
            splitList= oddSplit();
        }
        return splitList;

    }

    //split text with even length
    private List<List<Character>> evenSplit() {

        List<List<Character>> splitList= new ArrayList<List<Character>>();

        for (int i = 0; i< numOfSplits; i++){
            List<Character> subList= fileContent.subList(startingIndex, startingIndex+numOfElementsInSplit()-1);
            startingIndex= startingIndex+numOfElementsInSplit();
            splitList.add(subList);
        }

        return splitList;
    }


    //split text with oddList
    private List<List<Character>> oddSplit() {
        List<List<Character>> splitList= new ArrayList<>();
        for (int i = 0; i< numOfSplits -1; i++){
            List<Character> subList= fileContent.subList(startingIndex, startingIndex+numOfElementsInSplit()-1);
            startingIndex= startingIndex+numOfElementsInSplit();
            splitList.add(subList);
        }

        List<Character> subList= fileContent.subList(startingIndex, startingIndex+numOfElementsInSplit());
        startingIndex= startingIndex+numOfElementsInSplit();
        splitList.add(subList);
        return splitList;
    }

    //calculates the number of list elements that each split will have
    private int numOfElementsInSplit(){

        int numOfElements= fileContent.size()/ numOfSplits;
        return numOfElements;
    }
}
