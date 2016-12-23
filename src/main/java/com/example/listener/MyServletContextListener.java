package com.example.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by CPR199 on 2016-12-23.
 */
@WebListener
public class MyServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println(">>>>>>>>>>>>>>>ServletContex init<<<<<<<<<<<<<<<<<");
        System.out.println(servletContextEvent.getServletContext().getServerInfo());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println(">>>>>>>>>>>>>>>ServletContex destroy<<<<<<<<<<<<<<<<<");
    }
}
