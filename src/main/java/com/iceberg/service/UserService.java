package com.iceberg.service;

import com.iceberg.pojo.domain.User;

import java.util.List;

public interface UserService {

    /**
     * @Description: 判断用户名是否存在
     */
    public boolean queryUsernameIsExist(String username);

    /**
     * @Description: 查询用户是否存在
     */
    public User queryUser(String username, String password);

    /**
     * @Description: 保存用户
     */
    public User saveUser(User user);

}