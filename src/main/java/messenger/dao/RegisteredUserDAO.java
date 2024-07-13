package messenger.dao;

import jakarta.transaction.Transactional;
import messenger.user.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository
public class RegisteredUserDAO implements UserDAO {

    @Autowired
    private SessionFactory factory;

    @Override
    @Transactional
    public void saveUser(User user) {
        factory.getCurrentSession().save(user);
    }

    @Override
    @Transactional
    public boolean isExist(User user) {
        return factory.getCurrentSession().get(User.class,user) != null;
    }

}
