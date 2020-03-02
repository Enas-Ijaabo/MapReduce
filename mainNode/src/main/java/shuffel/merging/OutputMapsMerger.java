package shuffel.merging;

import mapper.global_output.MappersOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OutputMapsMerger {

    private Map<Object, List> globalOutputMap;
    List<Map> mappersOutputList;

    public OutputMapsMerger() {
        globalOutputMap = new HashMap<>();
        mappersOutputList= MappersOutput.getMapperOutputList();

    }

    /*Merge the different maps that each contain one value for each key,
      into one map that has a list of values for each key
     */
    public void startMerging(){

        for (Map partialMap: mappersOutputList){

            for ( Object key: partialMap.keySet() ) {

                if (!globalMapContainKey(key)){
                    addNewKey(key);
                }
                addValue(partialMap, key);
            }
        }
    }

    //check if the globalMap contains a key return true if the key exists, false otherwise
    private boolean globalMapContainKey(Object key) {
        if (globalOutputMap.containsKey(key)){
            return true;
        }
        return false;

    }

    /*add new key to the global Map,
    and sets it value to new arrayList that will contain the value objects*/
    private void addNewKey( Object key){

        globalOutputMap.put(key, new ArrayList());
    }

    //add a value object to the values arrayList, for an existing key in the global map
    private void addValue(Map partialMap, Object key){

        List valueList=  globalOutputMap.get(key);
        valueList.add(partialMap.get(key));
    }

    public Map<Object, List> getGlobalOutputMap() {
        return globalOutputMap;
    }
}
