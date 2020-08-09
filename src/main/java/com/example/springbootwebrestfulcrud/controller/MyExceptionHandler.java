package com.example.springbootwebrestfulcrud.controller;

import com.example.springbootwebrestfulcrud.exception.UserNotExistException;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {

    //处理指定的异常
//    @ExceptionHandler(UserNotExistException.class)
//    @ResponseBody
//    public Map<String,Object> handleException(Exception e){
//        Map<String,Object> map = new HashMap<>();
//        map.put("code","user.notexist");
//        map.put("message",e.getMessage());
//        return map;
//    }

    @ExceptionHandler(UserNotExistException.class)
    public String handleException(Exception e, HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        request.setAttribute("javax.servlet.error.status_code",404);
        map.put("code","user.notexist");
        map.put("message",e.getMessage());
        request.setAttribute("maps",map);
        //转发到/error，就会被BasicErrorController来进行自适应处理
        return "forward:/error";
    }
}
