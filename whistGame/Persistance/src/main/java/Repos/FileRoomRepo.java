package Repos;

import Interface.IRoomRepo;
import domain.app.Room;

import java.io.*;

public class FileRoomRepo implements IRoomRepo {


    @Override
    public Room findByID(int roomID) {
        Room foundRoom;
        String[] split;

        try{
            File userFile = new File("Persistance\\src\\main\\resources\\txtFiles\\User.txt");
            FileReader fr = new FileReader(userFile);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while((line = br.readLine()) != null){
                if(line.contains(Integer.toString(roomID))) {       // grija mare cu asta ca e scris inainte sa fie gata clasa Room
                    split = line.split("\\s");
                    foundRoom = new Room( Boolean.getBoolean(split[0]) , split[1], split[2], Integer.parseInt(split[3]));
                    //System.out.println(foundUser.getNickname() + " " + foundUser.getPassword());
                    return foundRoom;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(int roomID) {

    }

    @Override
    public void save(Room room) {
        try {
            File userFile = new File("Persistance\\src\\main\\resources\\txtFiles\\Rooms.txt");
            FileWriter fw = new FileWriter(userFile,true); // 'true'-ul face append
            BufferedWriter bw = new BufferedWriter(fw);

            String line =  room.isPublic() + " " + room.getPort() + " " + room.getIPadress() + " " + room.getPassword() ;
            bw.newLine();
            bw.write(line);

            bw.close();// super importatnt altfel nu scrie
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    @Override
    public void update(int roomID) {

    }


}
