package messenger.service;


import jakarta.transaction.Transactional;
import messenger.dao.RegisteredUserDAO;
import messenger.dao.UserDAO;
import messenger.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO registeredUserDAO;

    @Override
    @Transactional
    public void saveUser(User user) {
        registeredUserDAO.saveUser(user);
    }

    @Override
    @Transactional
    public User getUserByLogin(User user)
        {
            return registeredUserDAO.getUserByLogin(user);
        }

    @Override
    @Transactional
    public boolean loginIsExist(User user)
        {
            return registeredUserDAO.loginIsExist(user);
        }

    @Override
    @Transactional
    public boolean passwordIsExist(User user)
        {
            return registeredUserDAO.passwordIsExist(user);
        }


}
