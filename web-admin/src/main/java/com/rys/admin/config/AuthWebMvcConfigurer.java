package com.rys.admin.config;

import com.rys.admin.intercepter.AuthInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class AuthWebMvcConfigurer implements WebMvcConfigurer {

    @Bean
    public AuthInterceptor authInterceptor(){
        return new AuthInterceptor();
    }

    /**
     * 拦截URL
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        InterceptorRegistration interceptorRegistration = registry.addInterceptor(authInterceptor());
        //要拦截的路径
        interceptorRegistration.addPathPatterns("/**");
        interceptorRegistration.excludePathPatterns("/swagger-resources/**")
                .excludePathPatterns("/tStaff/login");
    }
}
