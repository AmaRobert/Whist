package serviceInterface;

public interface IAppService {

    void login(IAppObserver client); // add User object
    void logout(IAppObserver client); // add User object
    void getInfoData(); // add User object; return Data object
    void register(IAppObserver client); // add User object
    void joinRoom(); // add roomID; return (ipAddr, port) object
    void createRoom(String ipAddr, int port ); //add some data; return a roomID
    void startGame(); // add roomID
}
