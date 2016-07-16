package com.cloud.dao;

import com.cloud.entities.User;
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
 * Created by nikit on 13.07.2016.
 */

@Service("userService")
@Transactional
public class UserService {

    private static final Logger LOGGER = Logger.getLogger(UserService.class);

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    public List<User> getAll(){
        LOGGER.debug("Retrieving all persons");
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("FROM User");
        return query.list();
    }

    public User get(String email){
        Session session = sessionFactory.getCurrentSession();
        User user = (User) session.get(User.class, email);
        return user;
    }

    public void add(User user){
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    public void delete(Integer id){
        Session session = sessionFactory.getCurrentSession();

        User user = (User) session.get(User.class, id);
        session.delete(user);
    }
}
