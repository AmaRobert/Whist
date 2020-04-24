package Service;

import Domain.App.User;

public interface IAppService {
    void logIn(User user, IAppObserver client);
    void logOut(User user);
    void getInfoData(User user); //ToDo change return type
    void register(User user, IAppObserver client);
    void joinRoom(int roomId); //ToDo change return type to a new class which will return ip address and port
    int createRoom(String ipAddress, int port); //return the room key
    void startGame(int roomId);
}
