package objectProtocol;

import Service.IAppObserver;
import Service.IAppService;
import objectProtocol.request.Request;
import objectProtocol.response.Response;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class AppWorker implements Runnable, IAppObserver {

    private IAppService server;
    private Socket connection;


    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;
    private volatile boolean connected;


    public AppWorker(IAppService server, Socket connection) {
        this.server = server;
        this.connection = connection;

        try{
            outputStream = new ObjectOutputStream(connection.getOutputStream());
            outputStream.flush();
            inputStream = new ObjectInputStream(connection.getInputStream());
            connected = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateInfoData() {

    }

    @Override
    public void establishConnection(String ipAddress, int port) {

    }

    @Override
    public void setRoomId(int roomId) {

    }

    @Override
    public void notifyPlayer() {

    }

    @Override
    public void run() {

        while (connected){
            try{
                Object request = inputStream.readObject();
                Object response = handleRequest((Request) request);
                if (response != null)
                    sendResponse((Response) response);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

    }
}

    private Response handleRequest(Request request) {
        return null;
    }

    private void sendResponse(Response response) throws IOException {
        System.out.println("send response: " + response + " ...");
        outputStream.writeObject(response);
        outputStream.flush();;
    }
    }
