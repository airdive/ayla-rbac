package com.sunseaiot.rbac.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @description : 自定义MVC配置
 * @author: liuchuang
 * @date: 2018/4/13 下午3:43
 * @modified by:
 */
@Configuration
public class WebAppConfigurer implements WebMvcConfigurer {

    /**
     * CORS配置器
     * CORS全称是”跨域资源共享”（Cross-origin resource sharing），允许浏览器向跨源服务器，
     * 发出XMLHttpRequest请求，从而克服了AJAX只能同源使用的限制。
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  //允许任意请求路径
                .allowedHeaders("*")    //允许允许跨域请求包含任意的头信息
                .allowedMethods("*")    //允许任意请求方法（eg. GET,POST）
                .allowedOrigins("*");    //允许任意外域
    }
}
