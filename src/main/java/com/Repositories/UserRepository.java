package com.Repositories;

import com.Entities.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;


@Repository
public class UserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public Long insert(User user){
        return (Long) sessionFactory.getCurrentSession().save(user);

    }

    public void update(User user){
        sessionFactory.getCurrentSession().update(user);
    }


    public User findByUsernameAndPass(String username, String pass){
        Query query=sessionFactory.getCurrentSession().createQuery("FROM User WHERE username=:username AND pass=:pass AND isActive=:active")
                .setString("username",username)
                .setString("pass",pass)
                .setBoolean("active",true);

        User user=null;
        try {
            user=(User) query.getSingleResult();
        }catch (javax.persistence.NoResultException e){
            user=null;
        }
        return user;
    }

    public User findByUsername(String username){
        Query query=sessionFactory.getCurrentSession().createQuery("FROM User WHERE username=:username")
                .setString("username",username);
        return (User) query.getSingleResult();
    }

    public User findByKey(String key){
        Query query=sessionFactory.getCurrentSession().createQuery("FROM User WHERE regKey=:key")
                .setString("key",key);

        User user=null;
        try {
            user=(User) query.getSingleResult();
        }catch (javax.persistence.NoResultException e){
            user=null;
        }
        return user;
    }

}
