package Interface;

import Exceptions.UserNotFoundException;
import domain.app.User;

public interface IUserRepo {

     User findByName(String userName) throws UserNotFoundException; // it should return and object

     void save(User user);

     void update(User oldUser,User user); // oldUser, newUser? for parameters
     //delete eventual
}
