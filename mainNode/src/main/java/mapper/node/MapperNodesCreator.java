package mapper.node;

import shell_executor.ShellCommandExecutor;

public class MapperNodesCreator {

    private static MapperNodesCreator mapperNodesCreator;
    private static int numOfNodes;

    //singleton design pattern
    private MapperNodesCreator() {
    }

    //return the single instance of the MapperNodesCreator
    public static MapperNodesCreator getInstance() {
        if (mapperNodesCreator == null) {
            initialize();
        }
        return mapperNodesCreator;
    }

    //initialize the MapperNodesCreator single instance
    private static void initialize() {
        mapperNodesCreator = new MapperNodesCreator();
        numOfNodes = 0;
    }

    //use shell commands to create a docker swarm mapper service
    // the number of mapper service replicas= number of mapper nodes
    public void createNodes(int numOfMapperNodes) {

        numOfNodes = numOfMapperNodes;

        String sshCommand = "sshpass -p \"tcuser\" ssh -o StrictHostKeyChecking=no " +
                "-l docker 192.168.99.101 ";
        String command = "\"docker service create"
                + " --restart-condition none "
                + " --replicas " + numOfMapperNodes
                + " -p 10001:10001 "
                + "--network net1 "
                + "--name mapper enij/mapper_node 192.168.99.101\"";

        ShellCommandExecutor.executeCommand(sshCommand + command);

    }

    public static int getNumOfNodes() {
        return numOfNodes;
    }
}
