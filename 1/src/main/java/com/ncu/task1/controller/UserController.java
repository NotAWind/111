package com.ncu.task1.controller;

import com.ncu.task1.bean.JsonData;
import com.ncu.task1.param.UpdateParam;
import com.ncu.task1.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 周佳玲
 * @date 2019-07-14 12:44
 */
@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {
    UserService userService ;
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    /**
     * 修改用户信息
     * @param updateParam
     * @return
     * @throws Exception
     */
    @PostMapping("/updateUser")
    public JsonData updateUser(UpdateParam updateParam) throws Exception{
        userService.updateUser(updateParam);

        return JsonData.success();

    }


}
