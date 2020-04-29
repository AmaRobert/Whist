package domain.app;

import domain.Entity;

import java.util.ArrayList;
import java.util.List;

public class Room extends Entity<Integer>
{
    private boolean Public = false;


    private String IPadress;
    private int port  = 0;



    private boolean currentlyPlaying;
    private List<User> users = new ArrayList<>();

    //   private GameBoard  gb =  new GameBoard();

    public Room(boolean pub, String IP, int port){
        this.id = -1;
        this.setPublic(pub);
        currentlyPlaying = false; //cand am creat instanta obiectului, e clar ca jocul inca nu a inceput
        this.setIPadress(IP);
        this.setPort(port);
    }


    public void setPublic(boolean aPublic) {
        Public = aPublic;
    }

    public void setIPadress(String IPadress) {
        this.IPadress = IPadress;
    }
    public void setPort(int port) {
        this.port = port;
    }
    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void setCurrentlyPlaying(boolean currentlyPlaying) {
        this.currentlyPlaying = currentlyPlaying;
    }

    public boolean isPublic() {
        return Public;
    }

    public String getIPadress() {
        return IPadress;
    }
    public int getPort() {
        return port;
    }
    public List<User> getUsers() {
        return users;
    }


    public boolean isCurrentlyPlaying() {
        return currentlyPlaying;
    }


}
