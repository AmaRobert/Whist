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



}
