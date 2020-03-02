package shuffel.spliting;

import java.util.*;

public class MapSplitter {

    int numOfReducerNodes;
    Map<Object, List> globalOutputMap;
    List<Map> subMapsList;
    int subMapSize;

    public MapSplitter(int numOfReducerNodes, Map globalOutputMap) {
        this.numOfReducerNodes = numOfReducerNodes;
        this.globalOutputMap = globalOutputMap;
        subMapsList = new ArrayList<>();
        createMapList();
        initSubMapSize();
    }

    //create subMap list, and create a new hashMap for each reducer node
    private void createMapList() {

        for (int i=0; i<numOfReducerNodes; i++){
            subMapsList.add(new HashMap());
        }
    }

    //calculate and initialize each subMap size
    private void initSubMapSize() {
        int size= globalOutputMap.size();
        subMapSize= size/numOfReducerNodes;
    }

    /*split the large globalOutputMap which contains all mappers outputs,
    to subMaps */
    public List<Map> split() {

       int subMapIndex=0;
       Map subMap= subMapsList.get(0);
        for ( Object key: globalOutputMap.keySet() ) {

            subMap.put(key, globalOutputMap.get(key));

            if (subMap.size()>= subMapSize && subMapIndex+1<numOfReducerNodes){
              subMapIndex++;
              subMap= subMapsList.get(subMapIndex);
            }
        }

        return subMapsList;
    }

}
