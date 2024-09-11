package com.rys.user.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rys.user.intercepter.AuthInterceptor;
import com.rys.utils.DateConverter;
import java.nio.charset.StandardCharsets;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
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
        interceptorRegistration.excludePathPatterns("/swagger-resources/**");
    }

}
