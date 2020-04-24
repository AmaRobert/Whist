package Service;

public interface IAppObserver {
    void updateInfoData(); //parameter of type data
    void establishConnection(String ipAddress, int port);
    void setRoomId(int roomId);
    void notifyPlayer(); //parameter of list of players
}
