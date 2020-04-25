package Interface;

import domain.app.User;

public interface IUserRepo {

     User findByName(String userName); // it should return and object

     void save(User user);

     void update(String oldUserName,User user); // oldUser, newUser? for parameters
     //delete eventual
}
