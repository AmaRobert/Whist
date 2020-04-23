package serviceInterface;

public interface IAppObserver {
    void updateInfoData();
    void estabilishConnection(String ipAddr, int port);
    void setRoomID(); //add a roomID
    void notifyPlayers(); // add a List of Players
}
