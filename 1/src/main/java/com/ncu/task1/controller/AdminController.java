package com.ncu.task1.controller;

import com.ncu.task1.bean.JsonData;
import com.ncu.task1.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 周佳玲
 * @date 2019-07-14 12:44
 */
@RestController
@RequestMapping("/admin")
@Slf4j
public class AdminController {
    UserService userService;
    @Autowired
    public  AdminController(UserService userService){
        this.userService = userService;
    }

    @DeleteMapping("/delUser")
    /**
     * 通过Id 删除用户
     */

    public JsonData delUser(int id) throws Exception{
        log.info("要删除的用户Id：[{}]",id);
        userService.delUser(id);
        return JsonData.success();
    }


    
}
