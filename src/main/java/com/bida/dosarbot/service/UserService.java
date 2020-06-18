package com.bida.dosarbot.service;

import com.bida.dosarbot.domain.User;
import com.bida.dosarbot.repository.UserDAO;

import java.util.List;

public class UserService {

    private UserDAO userDAO;

    public UserService(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    public void addUser(User user){
        userDAO.save(user);
    }

    public List<User> getAllUsers(){
        return userDAO.selectAllEntity();
    }

    public User getUser(int year, int dosarNumber){return userDAO.selectUserByYearAndDosarNumber(year, dosarNumber);}
}
