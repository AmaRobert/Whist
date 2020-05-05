package Interface;


import Exceptions.FileRepoException;
import domain.app.Room;

public interface IRoomRepo {

    Room findBy(int roomID) throws FileRepoException;

    void delete(int roomID) throws FileRepoException;

    int save(Room room) throws FileRepoException;

    void update(Room room)throws FileRepoException;

}
