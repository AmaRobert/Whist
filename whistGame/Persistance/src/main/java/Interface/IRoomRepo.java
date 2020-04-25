package Interface;


import domain.app.Room;

public interface IRoomRepo {

    Room findByID(int roomID);

    void delete(int roomID);

    void save(Room room);

    void update(int roomID);

}
