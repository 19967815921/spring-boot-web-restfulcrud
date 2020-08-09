package com.example.springbootwebrestfulcrud.component;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

//给容器中添加我们自己的ErrorAttributes组件，springboot在用户没有定义ErrorAttribute时，
// 会创建默认的，在用户定义了自己的组件时，用用户的。
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        Map<String, Object> map = super.getErrorAttributes(webRequest, options);
        map.put("owner","ywj");
        map.put("why","no why");
        //第一个参数是作用域中存储的数据，第二个参数是选择相对应的作用域，0表示request，1表示session，2表示globalsession等
        Map<String,Object> maps = (Map<String, Object>) webRequest.getAttribute("maps",0);
        //这就是我们创建的异常处理器携带的数据
        map.put("maps",maps);
        return map;
    }
}
