package com.example.springbootwebrestfulcrud.controller;

import com.example.springbootwebrestfulcrud.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {

    @RequestMapping("/hello")
    @ResponseBody
    public String helloworld(){
        return "helloworld";
    }

    @RequestMapping("/success")
    public String success(){
        return "success";
    }

    @ResponseBody
    @RequestMapping("/helloworld")
    public String hello(@RequestParam("user") String user){
        if(user.equals("aaa")){
            throw new UserNotExistException();
        }
        return "hello";
    }
}
