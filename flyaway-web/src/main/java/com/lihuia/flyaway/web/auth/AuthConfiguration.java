package com.lihuia.flyaway.web.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lihuia.com
 * @date 2022/6/21 10:05 AM
 */

@Configuration
public class AuthConfiguration implements WebMvcConfigurer {


    @Bean
    public AuthInterceptor authInterceptor() {
        return new AuthInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> patterns = new ArrayList<>();
        patterns.add("/swagger/**");
        patterns.add("/v2/api-docs");
        patterns.add("/swagger-ui.html");
        patterns.add("/swagger-resources/**");
        patterns.add("/webjars/**");
        patterns.add("/error");
        patterns.add("/unittest/**");
        registry.addInterceptor(authInterceptor()).addPathPatterns("/**").excludePathPatterns(patterns);
    }
}
