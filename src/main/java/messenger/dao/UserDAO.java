package messenger.dao;

import messenger.user.User;

public interface UserDAO {
    void saveUser(User user);
    boolean isExist(User user);
}
