package messenger.service;

import messenger.user.User;

public interface UserService {
    void saveUser(User user);
    User getUserByLogin(User user);
    boolean loginIsExist(User user);
    boolean passwordIsExist(User user);
}
