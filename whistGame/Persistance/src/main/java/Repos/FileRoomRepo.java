package Repos;

import Exceptions.FileRepoException;
import Interface.IRoomRepo;
import domain.app.Room;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FileRoomRepo implements IRoomRepo {

    private List<Room> rooms;
    private boolean availableKey[] = new boolean[1000];//de la 000 la 999

    public FileRoomRepo() {
        rooms = new LinkedList<>();
        Arrays.fill(availableKey,true);
    }

    @Override
    public Room findBy(int roomID) throws FileRepoException {
        for(Room r: rooms){
            if(r.getId() == roomID)
                return r;
        }
        throw new FileRepoException("Room key doesn't exists!");
    }

    @Override
    public void delete(int roomID) throws FileRepoException {
        for(Room r:rooms){
            if(r.getId() == roomID) {
                rooms.remove(r);
                availableKey[roomID] = true;
                return;
            }
        }
        throw new FileRepoException("Room key doesn't exists!");
    }

    @Override
    public int save(Room room) throws FileRepoException {
        int key = generateKey();
        room.setId(key);
        rooms.add(room);
        availableKey[key] = false;
        return key;

    }

    private int generateKey() throws FileRepoException{
        for(int i=0; i<availableKey.length; i++){
            if(availableKey[i] == true){
                return i;
            }
        }
        throw new FileRepoException("Can't create a room right now!Try again later");
    }

    @Override
    public void update(Room room) throws FileRepoException {
        for(Room r : rooms){
            if(r.getId().equals(room.getId())){
               //folosind setteri, modificam elementul r(exemplu in clasa User)
                return;
            }
        }
        throw new FileRepoException("Can't find the room with key = " + room.getId());

    }
}
