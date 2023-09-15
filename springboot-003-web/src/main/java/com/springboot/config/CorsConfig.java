package com.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 设置允许跨域的路径
                .allowedOriginPatterns("*") // 设置允许跨域请求的域名
                .allowCredentials(true) // 是否允许Cookie
                .allowedMethods("GET", "POST", "DELETE", "PUT") // 设置允许的请求方式
                .allowedHeaders("*") // 设置允许的请求头
                .maxAge(3600); // 跨域允许时间
    }
}
