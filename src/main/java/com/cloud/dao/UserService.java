package com.cloud.dao;

import com.cloud.entities.User;
import com.cloud.exceptions.user.LoginAlreadyExistException;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.jws.soap.SOAPBinding;
import java.util.List;

/**
 * Created by Nikita on 13.07.2016.
 */

@Service("userService")
@Transactional
public class UserService {
    private static final String REGISTRATION_ERROR = "User with email '%s' already exists in system.";

    private static final Logger LOGGER = Logger.getLogger(UserService.class);

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    public List<User> getAll() {
        LOGGER.debug("Retrieving all persons");
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM User");
        return query.list();
        //для обновления
    }

    public User get(String email) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User where email = :emailParam");
        query.setParameter("emailParam", email);
        if (query.list().size() != 0) {
            User result = (User) query.list().get(0);
            return result;
        } else {
            return null;
        }
    }

    public void add(User user) throws LoginAlreadyExistException {
        Session session = sessionFactory.getCurrentSession();
        if (isEmailUnique(user.getEmail())) {
            session.save(user);
        } else {
            throw new LoginAlreadyExistException(String.format(REGISTRATION_ERROR, user.getEmail()));
        }
    }

    private boolean isEmailUnique(String email) {
        User user = get(email);
        return user == null;
    }

    public void delete(Integer id) {
        Session session = sessionFactory.getCurrentSession();

        User user = (User) session.get(User.class, id);
        session.delete(user);
    }
}
