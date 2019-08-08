package com.company.lee.service.iservice;

import com.company.lee.dao.pojo.User;

public interface UserService {

    String userExist(String username);

    String registry(User user);

    User login(User user);
}
