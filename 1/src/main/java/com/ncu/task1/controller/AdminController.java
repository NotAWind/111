package com.ncu.task1.controller;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 周佳玲
 * @date 2019-07-14 12:44
 */
@RequestMapping("/admin")
public class AdminController {
    @RequestMapping("/indexPages")
    public String indexPages(){
        return "admin/index";
    }
}
