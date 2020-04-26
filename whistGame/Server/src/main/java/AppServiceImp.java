import Repos.FileUserRepo;
import Service.AppException;
import Service.IAppObserver;
import domain.app.Room;
import domain.app.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

        // main utilitary Server App
        // De ce cacat nu se chama Server...?

public class AppServiceImp implements Service.IAppService{

    private List<User> onlinePlayers ;
    private List<Room> Rooms;
    private boolean availableKey[] = new boolean[1000];//de la 000 la 999

    public AppServiceImp(){
        onlinePlayers = new ArrayList<>();
        Arrays.fill(availableKey,true);
    }


    @Override
     // dintr-o lista de clienti
    public void logIn(User user) throws AppException {
        FileUserRepo fur =  new FileUserRepo();
        if(fur.exists(user)){
            User temp = fur.findByName(user.getId());
            if(user.getPassword() == temp.getPassword() && user.getId() == temp.getId()){
                onlinePlayers.add(user);

                // getInfoData(); ?
                //todo ar trebui sa mmai trimita si niste informatie la user despre cont in sine;
            }

        }else{
            throw new AppException("User " + user.getId() + "not found");
        }
    }



    @Override
    public void logOut(User user) {
        onlinePlayers.remove(user);
    }

    @Override // adauga un user nou
    public void register(User user) {
        FileUserRepo fur = new FileUserRepo();
        if(fur.exists(user) == false){
            fur.save(user);
        }
    }

    @Override// might need to return a string, just saying
    public int createRoom(String ipAddress, int port) {   //return the room key
        for (int i = 0; i < 1000; i++){
            if (availableKey[i] == true){
                availableKey[i] = false;
                return i;
            }
        }
        return -1; // it means that there are 1000 Rooms and we need to expand
    }

    @Override // should this even be here?
    public void joinRoom(int roomId) { }
    @Override // what should this do ...?
    public void startGame(int roomId) { }
    @Override //hell kows what it does
    public void getInfoData(User user) { }


    //---- Getters & Setters ----\\
    public List<User> getOnlinePlayers() {
        return onlinePlayers;
    }
    public void setOnlinePlayers(List<User> onlinePlayers) {
        this.onlinePlayers = onlinePlayers;
    }
    public boolean[] getAvailableKey() {
        return availableKey;
    }
    public void setAvailableKey(boolean[] availableKey) {
        this.availableKey = availableKey;
    }
}
