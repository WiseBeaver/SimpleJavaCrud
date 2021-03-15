package org.alex.service;

import org.alex.dao.UserDao;
import org.alex.model.User;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements InitializingBean {

    @Autowired
    private UserDao userDao;

    public void save(User user) {
        userDao.save(user);
    }

    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        userDao.save(new User(0, 18, "Alex"));
        userDao.save(new User(0, 39, "Dima"));
    }

    public void remove(Long id) {
        userDao.remove(id);
    }

    public User findById(Long id) {
        return userDao.findById(id);
    }

    public void update(User user) {
        userDao.update(user);
    }
}
