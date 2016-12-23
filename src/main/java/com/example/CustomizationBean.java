package com.example;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;

import org.springframework.stereotype.Component;

/**
 * Created by CPR199 on 2016-12-21.
 */
@Component
public class CustomizationBean implements EmbeddedServletContainerCustomizer {

    //配置tomcat 也可以在application.properties里面配置
    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        /*container.setPort(8080);
        container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND,"/404.html"));
        container.setSessionTimeout(10, TimeUnit.MINUTES);*/
    }

}