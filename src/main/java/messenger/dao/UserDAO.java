package messenger.dao;

import messenger.user.User;

public interface UserDAO {
    void saveUser(User user);
    User getUserByLogin(User user);
    boolean loginIsExist(User user);
    boolean passwordIsExist(User user);
}
