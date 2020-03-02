package reducer.request;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReducersRequestAcceptor {

    private ServerSocket serverSocket;
    private List<Map> reducersInputs;
    private String reducerCode;
    private int numOfReducers;
    private List<Thread> threads;


    public ReducersRequestAcceptor(ServerSocket serverSocket, List<Map> reducersInputs,
                                   String reducerCode, int numOfReducers) {
        this.serverSocket = serverSocket;
        this.reducersInputs = reducersInputs;
        this.reducerCode = reducerCode;
        this.numOfReducers = numOfReducers;
        threads= new ArrayList<>();
    }

    //Accept and handel each reducer client requests in new thread
    public void acceptReducersRequests(){

        int numOfClients=0;
        while (numOfClients<numOfReducers) {

            Socket socket = null;
            try {
                socket = serverSocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Map reducerInput = reducersInputs.get(numOfClients);
            numOfClients++;
            Thread thread=new Thread(new ReducerRequestHandler(socket, reducerInput, reducerCode));
            threads.add(thread);
            thread.start();
        }
        waitForTheThreads();
    }

    //waits for all threads to finish
    private void waitForTheThreads(){

        for (int i=0; i< threads.size(); i++){
            try {
                threads.get(i).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
