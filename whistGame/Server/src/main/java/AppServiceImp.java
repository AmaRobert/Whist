import Exceptions.FileRepoException;
import Exceptions.UserNotFoundException;
import Interface.IRoomRepo;
import Interface.IUserRepo;
import Repos.FileUserRepo;
import Service.AppException;
import Service.IAppObserver;
import Service.IAppService;
import domain.app.Room;
import domain.app.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// main utilitary Server App
        // De ce cacat nu se chama Server...?

public class AppServiceImp implements Service.IAppService{

    private Map<String,IAppObserver> loggedClients;
    private List<Room> Rooms;

    private IUserRepo userRepo;
    private IRoomRepo roomRepo;
    public AppServiceImp(IUserRepo userRepo,IRoomRepo roomRepo){
        loggedClients = new ConcurrentHashMap<>();

    }


    @Override
     // dintr-o lista de clienti
    public synchronized void logIn(User user,IAppObserver client) throws AppException {
        try {
            User userR = userRepo.findBy(user.getUsername(),user.getPassword());
            if(userR != null){
                if(loggedClients.containsKey(userR.getUsername()))
                    throw new AppException("Userul este deja conectat!\n");
                loggedClients.put(userR.getUsername(),client);
            }

        } catch (FileRepoException e) {
            throw new AppException("Autentificare esuata!");
        }

    }



    @Override
    public synchronized void logOut(User user,IAppObserver client) throws AppException {

        boolean res = loggedClients.remove(user.getUsername(),client);
        if(!res)
            throw new AppException("Clientul este deja deconectat!");
    }

    @Override // adauga un user nou
    public void register(User user,IAppObserver client) throws AppException{

        throw new AppException("Functia inca nu este implementata!");
        /*
        userRepo.save(user); // functia din UserRepo trebuie sa arunce eroare!!
        loggedClients.put(user.getUsername(),client);
        */


    }

    @Override// might need to return a string, just saying
    public int createRoom(String ipAddress, int port,boolean isPublic)throws AppException {   //return the room key
        Room room = new Room(isPublic,ipAddress,port);
        try {
            return roomRepo.save(room);
        } catch (FileRepoException e) {
            throw new AppException("Momentan nu se pot creea camere!Incercati mai tarziu!");
        }
    }

    @Override // should this even be here?
    public void joinRoom(int roomId) { }
    @Override // what should this do ...?
    public void startGame(int roomId) { }
    @Override //hell knows what it does
    public void getInfoData(User user) { }


    //---- Getters & Setters ----\\

}
