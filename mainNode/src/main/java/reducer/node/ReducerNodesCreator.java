package reducer.node;

import shell_executor.ShellCommandExecutor;

public class ReducerNodesCreator {

    private static ReducerNodesCreator reducerNodesCreator;
    private static int numOfNodes;

    //singleton design pattern
    private ReducerNodesCreator() {}

    //return the single instance of the ReducerNodesCreator
    public static ReducerNodesCreator getInstance(){
        if(reducerNodesCreator== null){
            initialize();
        }
        return  reducerNodesCreator;
    }

    //initialize the ReducerNodesCreator single instance
    private static void initialize() {
        reducerNodesCreator= new ReducerNodesCreator();
        numOfNodes=0;
    }

    //use shell commands to create a docker swarm reducer service
    // the number of reducer service replicas= number of reducer nodes
    public void createNodes( int numOfReducerNodes){

        numOfNodes=numOfReducerNodes;

            String sshCommand="sshpass -p \"tcuser\" ssh -o StrictHostKeyChecking=no " +
                    "-l docker 192.168.99.101 ";
            String command="\"docker service create"
                        +" --replicas "+numOfReducerNodes
                        +" -p 10002:10002 "
                        +" --restart-condition none "
                        +"--network net1 "
                        +"--name reducer enij/reducer_node 192.168.99.101\"";

        ShellCommandExecutor.executeCommand(sshCommand+ command);


    }

    public static int getNumOfNodes() {
        return numOfNodes;
    }
}
