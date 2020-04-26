package Repos;

import domain.app.Room;
import domain.app.User;

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
        try{
            User uFound = fur.findByName("Odrinn");
            System.out.println( "testFindByName : " +  uFound.getId() + " " + uFound.getPassword());
        }
        catch (Exception e){
            e.printStackTrace();
        }

        //User uFound = fur.findByName("Robert");

    }

    public static void testUpdateUser(){
        User  newUsr = new User("Hudy","123456789");
        FileUserRepo fur = new FileUserRepo();
        fur.update("mihai",newUsr);
    }

    public static void testUserExists(){

        User  newUsr = new User("Hudy","123456789");
        FileUserRepo fur = new FileUserRepo();
        System.out.println(fur.exists("Mihai"));
        System.out.println(fur.exists("Hudy"));


    }

    public static void testSaveRoom(){
        Room room = new Room(true, "12345","MyIP",25565);
        FileRoomRepo frr = new FileRoomRepo();

        frr.save(room);

//        System.out.println( uFound.getUsername() );
    }

    public static void main(String[] args) {

        //testSaveUser();
        //testFindUserByName();
        //testUpdateUser();
        //testUserExists();
        //testSaveRoom();

        FileUserRepo fur = new FileUserRepo();
        fur.save(new User("hudy","1234"));
        fur.writeUserFile();


    }
}
