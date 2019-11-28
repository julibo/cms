package com.julibo.pig.cms.config;

import com.julibo.pig.cms.tools.interceptor.BaseInterceptor;
import com.julibo.pig.cms.tools.interceptor.TimeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author carson
 * @date 2019-11-28
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

    @Autowired
    private TimeInterceptor timeInterceptor;

    @Autowired
    private BaseInterceptor baseInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(baseInterceptor).addPathPatterns("/**");
        registry.addInterceptor(timeInterceptor);
        super.addInterceptors(registry);
    }

}
