package shuffel;

import shuffel.merging.OutputMapsMerger;
import shuffel.spliting.MapSplitter;
import java.util.List;
import java.util.Map;

public class ShuffleTaskStarter {

   private int numOfReducerNodes;

    public ShuffleTaskStarter(int numOfSplitterNodes) {
        this.numOfReducerNodes = numOfSplitterNodes;
    }

    /*start shuffling task:
    merge all mappers output into one Map that contains all the keys, and a list of the key's values
    then split this map to smaller maps that are equal in size, each of them is an input of a reducer node
     */
    public List<Map> startShufflingTask() {
        Map mappersOutput = mergeAllMaps();
        List<Map> reducersInput= splitIntoEqualMaps( mappersOutput);
        return reducersInput;
    }

    // merge all mappers output into one Map that contains all the keys, and a list of the key's values
    private Map mergeAllMaps() {
        OutputMapsMerger mapsMerger= new OutputMapsMerger();
        mapsMerger.startMerging();
       return mapsMerger.getGlobalOutputMap();
    }

    //split this map to smaller maps that are equal in size, each of them is an input of a reducer node
    private List<Map> splitIntoEqualMaps(Map globalOutputMap) {
        MapSplitter mapSplitter= new  MapSplitter(numOfReducerNodes, globalOutputMap);
        List<Map> reducersInput= mapSplitter.split();
        return reducersInput;
    }
}
