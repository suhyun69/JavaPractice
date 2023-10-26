package com.example.demo.config;

import com.example.demo.interceptor.CustomInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        CustomInterceptor customInterceptor = new CustomInterceptor();
        registry.addInterceptor(customInterceptor)
                .addPathPatterns("/**");
    }
}
