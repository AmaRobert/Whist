package main.java.domain.app;

import java.util.ArrayList;
import java.util.List;
import domain.app.User;

public class Room //extends domain.Entity<> {// tre sa vedem ce ii punem ca ID
    {
    private boolean Public = false;
    private String password;

    private String IPadress;
    private int port  = 0;
    private List<User> users = new ArrayList<>();

 //   private GameBoard  gb =  new GameBoard();

        Room(boolean pub, String IP, int port){
            this.setPublic(pub);
            this.setPassword("");
            this.setIPadress(IP);
            this.setPort(port);
        }

        Room(boolean pub,String password, String IP, int port){
            this.setPublic(pub);
            this.setPassword(password);
            this.setIPadress(IP);
            this.setPort(port);
        }

        public void setPublic(boolean aPublic) {
            Public = aPublic;
        }
        public void setPassword(String password) {
            this.password = password;
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

        public boolean isPublic() {
            return Public;
        }
        public String getPassword() {
            return password;
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
    }
