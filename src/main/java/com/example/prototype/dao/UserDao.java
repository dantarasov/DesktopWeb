package com.example.prototype.dao;
import com.example.prototype.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserDao extends JpaRepository<User, Long> {
    User findByName(String username);


}
