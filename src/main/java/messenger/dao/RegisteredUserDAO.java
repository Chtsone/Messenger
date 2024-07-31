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
    public User getUserByLogin(User user) {
           return factory.getCurrentSession().get(User.class,user.getLogin());
        }
    @Override
    public boolean loginIsExist(User user) {
            return getUserByLogin(user) != null;
        }
    @Override
    public boolean passwordIsExist(User user) {
        if(loginIsExist(user)) return getUserByLogin(user).getPassword().equals(user.getPassword());
        else return false;
    }

}
