package objectProtocol;

import Service.AppException;
import Service.IAppObserver;
import Service.IAppService;
import domain.app.User;
import objectProtocol.request.Request;
import objectProtocol.response.Response;
import objectProtocol.response.updateResponse.UpdateResponse;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class AppProxy implements IAppService {

    private String host;
    private int port;

    private IAppObserver client;

    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;

    private Socket connection;

    private BlockingQueue<Response> qResponses;
    private volatile boolean finished;


    public AppProxy(String host, int port) {
        this.host = host;
        this.port = port;

        qResponses = new LinkedBlockingQueue<>();
    }

    @Override
    public void logIn(User user, IAppObserver client) {

    }

    @Override
    public void logOut(User user) {

    }

    @Override
    public void getInfoData(User user) {

    }

    @Override
    public void register(User user, IAppObserver client) {

    }

    @Override
    public void joinRoom(int roomId) {

    }

    @Override
    public int createRoom(String ipAddress, int port) {
        return 0;
    }

    @Override
    public void startGame(int roomId) {

    }


    private void initConnection() throws AppException {
        try{

            connection = new Socket(host,port);


            outputStream = new ObjectOutputStream(connection.getOutputStream());
            outputStream.flush();

            inputStream = new ObjectInputStream(this.connection.getInputStream());

            finished = false;

            startReader();


        } catch (UnknownHostException e) {
            throw new AppException("The server can't be reached right now!\nSorry and please try later!");
        } catch (IOException e) {
            throw new AppException("The server can't be reached right now!\nSorry and please try later!");
        }
    }


    private void startReader(){
        Thread th = new Thread(new ReaderThread());
        th.start();
    }

    private void closeConnection(){
        finished = true;
        try{
            inputStream.close();
            outputStream.close();
            connection.close();
            client = null;
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private void sendRequest(Request request) throws AppException {
        try {
            outputStream.writeObject(request);
            outputStream.flush();
        } catch (IOException e) {
            throw new AppException("Error sending response " + e.getMessage() + "...");
        }

    }


    private Response readResponse(){
        Response response = null;
        try {
            response = qResponses.take();
            System.out.println("PROXY -Response taken: " + response + "...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }

    private void handleUpdate(UpdateResponse response){


    }

    private class ReaderThread implements Runnable {
        @Override
        public void run() {
            while (!finished){
                try {
                    System.out.println("PROXY- READERTHREAD: Waiting response ...");
                    Object response = inputStream.readObject();
                    System.out.println("PROXY- READERTHREAD : response received: " + response + " ...");
                    if(response instanceof UpdateResponse){
                        handleUpdate((UpdateResponse) response);
                    }else{
                        try {
                            qResponses.put((Response) response);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
