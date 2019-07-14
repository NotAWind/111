package com.ncu.task1.controller;

import com.ncu.task1.bean.JsonData;

import com.ncu.task1.entity.UserEntity;
import com.ncu.task1.param.LoginParam;
import com.ncu.task1.param.RegisterParam;
import com.ncu.task1.repositoty.UserRepository;
import com.ncu.task1.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 周佳玲
 * @date 2019-07-13 13:54
 */
@RestController
@Slf4j
@RequestMapping("/web")
public class WebController {
    private UserService userService;
    @Autowired
    public WebController(UserService userService,UserRepository userRepository){
        this.userService = userService;
    }

    /**
     * 用户注册
     * @param registerParam
     * @return
     * @throws Exception
     */
    @PostMapping("/register")
    public JsonData register(RegisterParam registerParam) throws Exception{
        log.info("用户注册信息为：[{}]",registerParam.toString());
        userService.addUser(registerParam);
        return JsonData.success();

    }

    @GetMapping("/login")
    public JsonData login(LoginParam loginParam) throws Exception{
        UserEntity userEntity = userService.login(loginParam);
        return JsonData.success(userEntity.getRole());
    }




}
