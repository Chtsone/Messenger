package messenger.dao;

import messenger.user.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class RegisteredUserDAO implements UserDAO {

    @Autowired
    private SessionFactory factory;

    @Override
    public void saveUser(User user) {
        factory.getCurrentSession().save(user);
    }

    @Override
    public boolean isExist(User user) {
        User userFromBD = factory.getCurrentSession().get(User.class,user.getLogin());
        if(userFromBD != null) return userFromBD.getPassword().equals(user.getPassword());
        else return false;
    }

}
