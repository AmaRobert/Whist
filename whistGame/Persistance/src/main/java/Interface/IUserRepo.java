package Interface;

import Exceptions.FileRepoException;
import Exceptions.UserNotFoundException;
import domain.app.User;

import java.io.File;

public interface IUserRepo {

     User findBy(String username,String password) throws FileRepoException;// it should return and object

     void save(User user) throws FileRepoException;

     void update(User user)throws FileRepoException; // oldUser, newUser? for parameters
     //delete eventual
}
