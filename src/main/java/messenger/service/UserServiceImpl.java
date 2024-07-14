package messenger.service;


import jakarta.transaction.Transactional;
import messenger.dao.RegisteredUserDAO;
import messenger.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private RegisteredUserDAO registeredUserDAO;

    @Override
    @Transactional
    public void saveUser(User user) {
        registeredUserDAO.saveUser(user);
    }

    @Override
    @Transactional
    public boolean isExist(User user) {
        return registeredUserDAO.isExist(user);
    }
}
