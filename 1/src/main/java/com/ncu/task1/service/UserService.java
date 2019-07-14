package com.ncu.task1.service;

import com.ncu.task1.entity.UserEntity;
import com.ncu.task1.param.LoginParam;
import com.ncu.task1.param.RegisterParam;


public interface UserService {
    public void addUser(RegisterParam registerParam) throws Exception;
    public UserEntity login(LoginParam loginParam) throws Exception;
}
