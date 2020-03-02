package mapper.node;

import shell_executor.ShellCommandExecutor;

public class MapperNodesRemover {

    private static MapperNodesRemover mapperNodesRemover;

    //singleton design pattern
    private MapperNodesRemover() {}

    //return the single instance of the MapperNodesRemover
    public static MapperNodesRemover getInstance(){
        if(mapperNodesRemover== null){
            initialize();
        }
        return  mapperNodesRemover;
    }

    //initialize the MapperNodesRemover single instance
    private static void initialize() {
        mapperNodesRemover= new MapperNodesRemover();
    }

    //use shell commands to remove a docker swarm mapper service
    public void removeNodes(){
        String sshCommand="sshpass -p \"tcuser\" ssh -o StrictHostKeyChecking=no " +
                "-l docker 192.168.99.101 ";

        String command="\"docker service rm mapper\"";
        ShellCommandExecutor.executeCommand(sshCommand+command);
    }
}
