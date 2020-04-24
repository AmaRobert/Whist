package utils;

import Service.IAppService;
import objectProtocol.AppWorker;


import java.net.Socket;

public class MainObjectServer extends AbstractConcurrentServer {

    private IAppService appServer;
    public MainObjectServer(int port, IAppService appServer) {
        super(port);
        this.appServer = appServer;
        System.out.println("App -- Object Concurrent Server");
    }

    @Override
    protected Thread createWorker(Socket client) {
        AppWorker worker = new AppWorker(appServer,client);
        Thread th = new Thread(worker);
        return th;
    }
}
