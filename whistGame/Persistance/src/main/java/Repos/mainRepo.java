package Repos;

import domain.app.Room;
import domain.app.User;

import java.io.*;
import java.nio.file.Files;

public class mainRepo {

    public static void testSaveUser(){
        User  usr = new User("Mihai","1234");
        FileUserRepo fur = new FileUserRepo();
        fur.save(usr);
        usr =  new User("Odrin", "bicicleta13");
        fur.save(usr);
        usr =  new User("Robert", "calutuNostru");
        fur.save(usr);
//        System.out.println( uFound.getUsername() );
    }

    public static void testFindUserByName(){
        User  usr = new User("mihai","1234");
        FileUserRepo fur = new FileUserRepo();
       // User uFound = fur.findByName("Mihai");
        User uFound = fur.findByName("Odrin");
        //User uFound = fur.findByName("Robert");
        System.out.println( "testFindByName : " +  uFound.getId() + " " + uFound.getPassword());
    }

    public static void testUpdateUser(){
        User  newUsr = new User("Hudy","123456789");
        FileUserRepo fur = new FileUserRepo();
        fur.update("mihai",newUsr);
    }

    public static void testSaveRoom(){
        Room room = new Room(true, "12345","MyIP",25565);
        FileRoomRepo frr = new FileRoomRepo();

        frr.save(room);

//        System.out.println( uFound.getUsername() );
    }

    public static void main(String[] args) {

        testSaveUser();
        testFindUserByName();
        //testUpdateUser();
        //testSaveRoom();

    }
}
