package mapper;

import mapper.node.MapperNodesCreator;
import mapper.node.MapperNodesRemover;
import mapper.request.MappersRequestAcceptor;
import splitter.TextSplits;

import java.net.ServerSocket;

public class MapTaskStarter {

    int mapperNodesNum;
    TextSplits textSplits;
    String mapperCode;
    ServerSocket serverSocket;

    public MapTaskStarter(int mapperNodesNum, TextSplits textSplits, String mapperCode, ServerSocket serverSocket) {
        this.mapperNodesNum = mapperNodesNum;
        this.textSplits = textSplits;
        this.mapperCode = mapperCode;
        this.serverSocket =serverSocket;
    }

    //start mapping stage
    public void startMapTask(){

         createMapperNodes();
         acceptMapperRequest();
         removeMapperNodes();
    }

    //create mapper nodes
    private void createMapperNodes() {

        MapperNodesCreator mapperNodesCreator= MapperNodesCreator.getInstance();
        mapperNodesCreator.createNodes(mapperNodesNum);
    }

    //accept and handel all mapper nodes requests
    private void acceptMapperRequest() {
        MappersRequestAcceptor mappersRequestAcceptor= new MappersRequestAcceptor
                (serverSocket , textSplits, mapperCode, mapperNodesNum );
        mappersRequestAcceptor.acceptMappersRequests();
    }

    //remove mapper nodes
    private void removeMapperNodes() {
        MapperNodesRemover mapperNodesRemover= MapperNodesRemover.getInstance();
        mapperNodesRemover.removeNodes();
    }

}
