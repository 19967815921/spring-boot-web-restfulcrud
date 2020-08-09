package com.example.springbootwebrestfulcrud.config;

import com.example.springbootwebrestfulcrud.component.LoginHandlerInterceptor;
import com.example.springbootwebrestfulcrud.component.MyLocalResolver;
import org.apache.tomcat.util.descriptor.LocalResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;

//使用webMvcConfigurerAdapter可以来扩展SpringMVC的功能
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
    //浏览器发送/hei 请求来到success
        registry.addViewController("/hei").setViewName("success");
    }

    //所有的WebMvcConfigurerAdapter组件都会一起起作用
    @Bean //将组件注册在容器
    public MyMvcConfig myMvcConfigy(){
        MyMvcConfig adapter = new MyMvcConfig() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
            }
//
//            //注册拦截器
//            @Override
//            public void addInterceptors(InterceptorRegistry registry) {
//                //拦截所有的页面，除了和登录页面相关资源，以及静态资源
//               registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
//                    .excludePathPatterns("index.html","/","user/login")
//                    .excludePathPatterns("*.css","*.js");
//            }
        };
        return adapter;
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocalResolver();
    }
}
