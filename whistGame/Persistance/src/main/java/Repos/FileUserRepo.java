package Repos;

import Interface.IUserRepo;
import domain.app.User;

import java.io.*;
import java.util.Scanner;

public class FileUserRepo implements IUserRepo {


    @Override
    public User findByName(String userName) {

        User foundUser;
        String[] split;

        try{
            File userFile = new File("Persistance\\src\\main\\resources\\txtFiles\\User.txt");
            FileReader fr = new FileReader(userFile);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while((line = br.readLine()) != null){
                if(line.contains(userName)) {
                    split = line.split("\\s");
                    foundUser = new User(split[0], split[1]);
                    System.out.println(foundUser.getNickname() + " " + foundUser.getPassword());
                    return foundUser;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(User user) {// untested
        try {
            File userFile = new File("Persistance\\src\\main\\resources\\txtFiles\\User.txt");
            FileWriter fw = new FileWriter(userFile,true); // 'true'-ul face append
            BufferedWriter bw = new BufferedWriter(fw);

            String line =  user.getNickname() + " " + user.getPassword();
            bw.newLine();
            bw.write(line);

            bw.close();// super importatnt altfel nu scrie
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(String oldUserName,User newUser) {
        User foundUser = new User("","");
        String[] split;

        try{
            String filePath = "Persistance\\src\\main\\resources\\txtFiles\\User.txt";

            Scanner sc = new Scanner(new File(filePath));

            StringBuffer buffer = new StringBuffer();
            String line;

            while (sc.hasNextLine()) {
                line =  sc.nextLine();
                buffer.append(line+System.lineSeparator());

                System.out.println("line  : " + line);

                if( line.contains(oldUserName) ) {
                    System.out.println("found something");
                    split = line.split("\\s");
                    foundUser = new User(split[0], split[1]);
                }
            }

            System.out.println( "UpdateTest : " + foundUser.getNickname() + " " + foundUser.getPassword());
            String fileContents = buffer.toString();
            sc.close();

            String oldUsr = foundUser.getNickname() + " " + foundUser.getPassword();
            String newUsr = newUser.getNickname() + " " + newUser.getPassword() ;

            fileContents = fileContents.replaceAll(oldUsr, newUsr);

            FileWriter writer = new FileWriter(filePath);

            writer.append(fileContents);
            writer.flush();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
