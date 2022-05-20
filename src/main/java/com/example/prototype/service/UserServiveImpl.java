package com.example.prototype.service;
import com.example.prototype.dao.RoleDao;
import com.example.prototype.dao.UserDao;
import com.example.prototype.model.Role;
import com.example.prototype.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
// implementation of US interface



@Service
public class UserServiveImpl implements  UserService{

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;


    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

// sign upped user get a role
    @Override
    public boolean save(User user) {
      user.setPassword(bCryptPasswordEncoder.encode(user.getPassword())); // encrypting password
      Set<Role> roles= new HashSet<>(); // set role for user
        roles.add(roleDao.getOne(1L));//add one role to user
        user.setRoles(roles); //set it
        userDao.save(user);
        return false;
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByName(username);// get user from
    }
}
