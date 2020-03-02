import reduce.handler.MainNodeResponseHandler;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {

        //start the server, send request to the server and handle the response ,accept client requests
        public static void main(String[] args) {

            try {
                ServerSocket serverSocket = new ServerSocket(10002);
                System.out.println("Reducer Server on...");
                Socket socket= new Socket(args[0], 10000);
                sendRequestToMainNode(socket);
                handleMainNodeResponse(socket);

                while (true) {

                    acceptRequest(serverSocket);
                }

            } catch (IOException ioException) {
                System.err.println(ioException.getMessage());
            }
        }

    private static void sendRequestToMainNode(Socket socket) {
            String status="Reducer ready";
        try {
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(status);
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleMainNodeResponse(Socket socket) {
            try {
                DataInputStream dataInputStream= new DataInputStream(socket.getInputStream());
                ObjectOutputStream objectOutputStream= new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream objectInputStream= new ObjectInputStream(socket.getInputStream());

                MainNodeResponseHandler mapRequestHandler=
                        new MainNodeResponseHandler(dataInputStream, objectOutputStream,objectInputStream);
                mapRequestHandler.handleResponse();
            } catch (IOException e) {
                e.printStackTrace();
            }

    }

    //Accept and handle requests
    private static void acceptRequest(ServerSocket serverSocket ) throws IOException {

        Socket socket = serverSocket.accept();
    }

    }

