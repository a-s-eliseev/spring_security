package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public List<User> listUsers() {
        TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public void deleteUser(User user) {
        sessionFactory.getCurrentSession().delete(user);
    }

    @Override
    public User getUser(Long id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    public void editUser(User user) {
        sessionFactory.getCurrentSession().update(user);
    }
}
