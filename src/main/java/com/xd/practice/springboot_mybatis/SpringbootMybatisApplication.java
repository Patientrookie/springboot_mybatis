package com.xd.practice.springboot_mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.spring.web.SpringfoxWebMvcConfiguration;

/**
 * @author xiaqi
 * 使用knife4j的时候一定要写@ConditionalOnClass(SpringfoxWebMvcConfiguration.class)
 */
@SpringBootApplication
@ConditionalOnClass(SpringfoxWebMvcConfiguration.class)
@MapperScan(basePackages = "com.xd.practice.springboot_mybatis.dao")
public class SpringbootMybatisApplication implements WebMvcConfigurer {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisApplication.class, args);
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
