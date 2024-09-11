package com.rys.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ApplicationConfig {
    @Bean
    public RestTemplate getRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        List<HttpMessageConverter<?>> httpMessageConverters = restTemplate.getMessageConverters();
        httpMessageConverters.removeIf( value -> value instanceof MappingJackson2HttpMessageConverter);
        httpMessageConverters.add( new MappingJackson2HttpMessageConverter() {
            public List<MediaType> getSupportedMediaTypes() {
                List<MediaType> arrayList = new ArrayList<>( super.getSupportedMediaTypes() );
                arrayList.add( MediaType.TEXT_PLAIN );
                return arrayList;
            }
        } );
        return restTemplate;
    }
}
