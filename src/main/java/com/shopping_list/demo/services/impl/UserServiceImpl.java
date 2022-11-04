package com.shopping_list.demo.services.impl;

import com.shopping_list.demo.models.entities.User;
import com.shopping_list.demo.models.service.UserServiceModel;
import com.shopping_list.demo.repository.UserRepository;
import com.shopping_list.demo.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean register(UserServiceModel userServiceModel) {
        try {
            this.userRepository.save(modelMapper.map(userServiceModel, User.class));
        } catch (Exception e){
            return false;
        }
       return true;
    }

    @Override
    public UserServiceModel findByUserAndPassword(String username, String password) {
        return this.userRepository.findByUsernameAndPassword(username, password)
                .map(user -> modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }
}
