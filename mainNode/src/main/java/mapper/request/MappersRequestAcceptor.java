package mapper.request;

import splitter.TextSplits;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MappersRequestAcceptor {

    private ServerSocket serverSocket;
    private TextSplits textSplits;
    private String mapperCode;
    private int mapperNum;
    private List<Thread> threads;

    public MappersRequestAcceptor(ServerSocket serverSocket, TextSplits textSplits
            , String mapperCode, int mapperNum) {
        this.serverSocket = serverSocket;
        this.textSplits = textSplits;
        this.mapperCode = mapperCode;
        this.mapperNum = mapperNum;
        threads= new ArrayList<>();
    }

    //Accept and handel each mapper client requests in new thread
    public void acceptMappersRequests(){
        int numOfClients=0;

        while (numOfClients<mapperNum) {

            Socket socket = null;
            try {
                socket = serverSocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
            numOfClients++;
            List<Character> textSplit =textSplits.getNextSplit();
            Thread thread=new Thread(new MapperRequestHandler(socket, textSplit, mapperCode));
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
