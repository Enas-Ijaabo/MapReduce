package reducer;

import reducer.node.ReducerNodesCreator;
import reducer.node.ReducerNodesRemover;
import reducer.request.ReducersRequestAcceptor;
import java.net.ServerSocket;
import java.util.List;
import java.util.Map;

public class ReduceTaskStarter {

    int reducerNodesNum;
    List<Map> reducersInputs;
    String reducerCode;
    ServerSocket serverSocket;

    public ReduceTaskStarter(int reducerNodesNum, List<Map> reducersInputs
            , String reducerCode, ServerSocket serverSocket) {
        this.reducerNodesNum = reducerNodesNum;
        this.reducersInputs = reducersInputs;
        this.reducerCode = reducerCode;
        this.serverSocket = serverSocket;
    }

    //start reducing stage
    public void startReduceTask(){

         createReducerNodes();
         acceptReducingRequest();
         removeReducerNodes();
    }

    //create reducers nodes
    private void createReducerNodes() {

        ReducerNodesCreator reducerNodesCreator= ReducerNodesCreator.getInstance();
        reducerNodesCreator.createNodes(reducerNodesNum);
    }

    //accept and handel all mapper nodes requests
    private void acceptReducingRequest() {
        ReducersRequestAcceptor reducersRequestAcceptor= new ReducersRequestAcceptor
                (serverSocket , reducersInputs, reducerCode, reducerNodesNum );
        reducersRequestAcceptor.acceptReducersRequests();
    }

    //remove reducer nodes
    private void removeReducerNodes() {
        ReducerNodesRemover reducerNodesRemover= ReducerNodesRemover.getInstance();
        reducerNodesRemover.removeNodes();
    }
}
