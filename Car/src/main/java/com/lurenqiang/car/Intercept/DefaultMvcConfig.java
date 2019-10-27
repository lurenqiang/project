package com.lurenqiang.car.Intercept;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DefaultMvcConfig implements WebMvcConfigurer {
    private LoginIntercept loginIntercept;

    public DefaultMvcConfig(LoginIntercept loginIntercept)
    {
        this.loginIntercept=loginIntercept;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login_in");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> extendUrl = new ArrayList<>();
        extendUrl.add("/login/login_in");
        extendUrl.add("/login/verifyLogin");
        registry.addInterceptor(loginIntercept).addPathPatterns("/**").excludePathPatterns(extendUrl);
    }
    /**
     * 配置静态访问资源
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }

}
