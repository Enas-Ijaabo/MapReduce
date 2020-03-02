package reducer.node;

import shell_executor.ShellCommandExecutor;

public class ReducerNodesRemover {

    private static ReducerNodesRemover reducerNodeRemover;

    //singleton design pattern
    private ReducerNodesRemover() {}

    //return the single instance of the ReducerNodesRemover
    public static ReducerNodesRemover getInstance(){
        if(reducerNodeRemover == null){
            initialize();
        }
        return reducerNodeRemover;
    }

    //initialize the ReducerNodesRemover single instance
    private static void initialize() {
        reducerNodeRemover = new ReducerNodesRemover();
    }

    //use shell commands to remove a docker swarm reducer service
    public void removeNodes(){

        String sshCommand="sshpass -p \"tcuser\" ssh -o StrictHostKeyChecking=no " +
                "-l docker 192.168.99.101 ";
        String command="\"docker service rm reducer\"";
        ShellCommandExecutor.executeCommand(sshCommand+command);
    }
}
