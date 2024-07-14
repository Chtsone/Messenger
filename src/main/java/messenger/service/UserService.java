package messenger.service;

import messenger.user.User;

public interface UserService {
    void saveUser(User user);
    boolean isExist(User user);
}
