package com.ykjava.controller;

import com.ykjava.mapper.UserMapper;
import com.ykjava.modal.User;
import com.ykjava.service.HelloWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by baoz on 2017/3/9.
 */
@Controller
public class HelloWorldController {
    @Autowired
    private HelloWordService helloWordService;

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("sayHw")
    @ResponseBody
    public String sayHw() {
        return "Hello world";
    }

    @RequestMapping("/invokeService")
    @ResponseBody
    public String invokeService() {
        return helloWordService.geneString();
    }


    @RequestMapping("/randomAddOne")
    @ResponseBody
    public String randomAddOne(@RequestParam("name") String name,
                               @RequestParam("age") Integer age) {
        User u = new User();
        u.setAge(age);
        u.setName(name);

        userMapper.addOne(u);
        return "ok";
    }

    @RequestMapping("/randomAddOne2")
    @ResponseBody
    public String randomAddOne2(@RequestParam("name") String name,
                               @RequestParam("age") Integer age) {
        userMapper.addOneRaw(name, age);
        return "ok";
    }

    @RequestMapping("/getAllUser")
    @ResponseBody
    public List<User> getAllUser() {
        return userMapper.getAll();
    }

    @RequestMapping("/getOne")
    @ResponseBody
    public User getOne(@RequestParam("id") int id) {
        return userMapper.getOne(id);
    }
}
