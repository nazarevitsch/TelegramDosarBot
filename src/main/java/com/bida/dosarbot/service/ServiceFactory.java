package com.bida.dosarbot.service;

import com.bida.dosarbot.repository.UserDAO;

public class ServiceFactory {

    public UserService getUserService(){
        return new UserService(new UserDAO());
    }
}
