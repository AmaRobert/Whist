package Service;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IAppObserver extends Remote {
    void updateInfoData() throws RemoteException; //parameter of type data
    void establishConnection(String ipAddress, int port)  throws RemoteException;
    void setRoomId(int roomId) throws RemoteException;
    void notifyPlayers() throws RemoteException; //parameter of list of players
}
