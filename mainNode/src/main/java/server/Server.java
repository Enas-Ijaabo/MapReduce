package server;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {

    private static Server server;
    private static ServerSocket serverSocket;

    //singleton design pattern
    private Server() {}

    //return the single instance of the Server
    public static Server getInstance(){
        if(server== null){
            initializeServer();
        }
        return  server;
    }

    //initialize the server single instance and the serverSocket Configuration
    private static void initializeServer() {
        server= new Server();
      try {
          serverSocket= new ServerSocket(10000);

      } catch (IOException e) {
          e.printStackTrace();
      }
    }

    public ServerSocket getServerSocket(){
        return serverSocket;
    }


}
