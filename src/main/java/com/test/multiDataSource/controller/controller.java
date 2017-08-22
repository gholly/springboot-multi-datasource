package com.test.multiDataSource.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.multiDataSource.model.manage.LoginLog;
import com.test.multiDataSource.model.test.User;
import com.test.multiDataSource.service.manage.LoginLogService;
import com.test.multiDataSource.service.test.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

/**
 * Created by guanguan on 2017/7/20.
 */
@Controller
public class controller {
    @Autowired
    UserService userService;
    @Autowired
    LoginLogService loginLogService;

//    @RequestMapping("/")
//     public String index(ModelMap model){
//        List <User> userList = userService.getAll(new User());
//         model.addAttribute("user",userList.get(0));
//        return "index";
//    }


    @RequestMapping("/")
    @ResponseBody
    public String index() {
        Integer page=2;
        Integer rows=3;

        PageHelper.startPage(page, rows);
        List<User> userList = userService.findBy(new HashMap<Object, Object>());
        PageInfo pageInfo = new PageInfo(userList);
        List<LoginLog> loginLogList = loginLogService.findBy(new HashMap<Object, Object>());

        return JSON.toJSONString(userList)+JSON.toJSONString(loginLogList.get(0));
     }
}
