package com.iceberg.service.impl;

import com.iceberg.pojo.domain.User;
import com.iceberg.repository.UserRepository;
import com.iceberg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public boolean queryUsernameIsExist(String username) {
        User user = userRepository.findByUsername(username);
        // user != null ? true: false;
        return user != null;
    }

    @Override
    public User queryUser(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        Example<User> userExample = Example.of(user);
        Optional<User> optionalUser = userRepository.findOne(userExample);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        }
        return null;
    }

    @Override
    public User saveUser(User user) {
        user.setQrCode("");
        return userRepository.save(user);
    }
}
