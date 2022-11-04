package com.shopping_list.demo.services;


import com.shopping_list.demo.models.service.UserServiceModel;



public interface UserService {
    boolean register(UserServiceModel map);

   UserServiceModel findByUserAndPassword(String username, String password);

}
