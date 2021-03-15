package org.alex.dao;


import org.alex.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class UserDao  {
    private long seq_id=0;
    private Map<Long, User> userDB=new HashMap<>();
    public void save(User user){
      long id=++seq_id;
      user.setId(id);
      userDB.put(id,user);
    }
    public List<User> findAll(){
        return userDB.values().stream().collect(Collectors.toList());
    }

    public void remove(Long id) {
        userDB.remove(id);
    }

    public User findById(Long id) {
        return userDB.get(id);
    }

    public void update(User user) {
        userDB.put(user.getId(),user);
    }
}
