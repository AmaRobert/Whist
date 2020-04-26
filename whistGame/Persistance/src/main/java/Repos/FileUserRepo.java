package Repos;

import Exceptions.UserNotFoundException;
import Interface.IUserRepo;
import domain.app.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUserRepo implements IUserRepo {

    // brings everything from the files   into object form

    public static List<User> users;
                                                                        // doar ca sa o scrie in acelasi loc
    public static String path = "whistGame\\Persistance\\User.txt";     // puteti sa o modificati in constructor

//-------------Constructors-----------------------

    public FileUserRepo(String path){
        this.setPath(path);
        this.setUsers(getAllUsers());
    }

    public FileUserRepo(){
        this.setUsers(getAllUsers());
    }


//-----------------------------------------------

    @Override
    public User findByName(String userName)  {
        for (User u: users) {
            if(u.getId() == userName){
                return u;
            }
        }
        return null;
    }

    @Override
    public void save(User user) {// untested
        users.add(user);
    }

    public void delete(User user) {// untested
        users.remove(user);
    }

    public List<User> getAllUsers(){
        List<User> users = new ArrayList<>();
        String[] split;
        try{
            File userFile = new File(path);
            FileReader fr = new FileReader(userFile);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while((line = br.readLine()) != null){
                split = line.split("\\s");
                User usr = new User(split[0],split[1]); // de inlocuit linia asta de cod cu un foreac prin split
                users.add(usr);
                System.out.println(usr.getId() + " " + usr.getPassword());
            }


        }catch (Exception e){
            e.printStackTrace();
        }

        return users;
    }

    public void writeUserFile(){
        try { // daca da fail pe la mijloc corupe fisierul
            File userFile = new File(path);
            FileWriter fw = new FileWriter(userFile,false); // 'true'-ul face append
            BufferedWriter bw = new BufferedWriter(fw);

                for (User u: users) {
                    String line = u.getId() + " " + u.getPassword();
                    bw.write(line);
                    bw.newLine();
                }
                    bw.close();// super importatnt altfel nu scrie
        }catch (Exception e){
                    System.out.println("Verifica-ti fisierul de Users.txt ca probabil nu l-o scris corect");
                    e.printStackTrace();
        }
    }

    @Override// a nu se folosi dupa update nu crapa da' face cacaturi si nu-s sigur ce (Hudy)
    public void update(User oldUser,User newUser) {
       if(users.contains(oldUser)){
            users.remove(oldUser);
            users.add(newUser);
       }
    }

    public  boolean exists(User user){
       if (users.contains(user)){
           return true;
       }
       return false;
    }


    //------ Getters & Setters -----\\

    public static List<User> getUsers() {
        return users;
    }
    public static void setUsers(List<User> users) {
        FileUserRepo.users = users;
    }
    public static String getPath() {
        return path;
    }
    public static void setPath(String path) {
        FileUserRepo.path = path;
    }
}
