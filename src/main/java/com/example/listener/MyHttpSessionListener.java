package com.example.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by CPR199 on 2016-12-23.
 */
@WebListener
public class MyHttpSessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println(">>>>>>>>>>>>>>>Session init<<<<<<<<<<<<<<<<<");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println(">>>>>>>>>>>>>>>ServletContex destroy<<<<<<<<<<<<<<<<<");
    }
}
