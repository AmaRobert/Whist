package Service;


import domain.app.User;

public interface IAppService {
    void logIn(User user, IAppObserver client) throws AppException;
    void logOut(User user,IAppObserver client) throws AppException;
    void getInfoData(User user); //ToDo change return type
    void register(User user, IAppObserver client) throws AppException;
    void joinRoom(int roomId); //ToDo change return type to a new class which will return ip address and port
    int createRoom(String ipAddress, int port,boolean isPublic)throws AppException; //return the room key
    void startGame(int roomId);
}
