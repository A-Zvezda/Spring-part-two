package com.geekbrains.geekmarketwinter.controllers;

import com.geekbrains.geekmarketwinter.utils.HttpSessionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.concurrent.atomic.AtomicInteger;

@WebListener
public class CustomSessionListener implements HttpSessionListener {
    private HttpSessionUtils httpSessionUtils;
    @Autowired
    public void setHttpSessionUtils(HttpSessionUtils httpSessionUtils) {
        this.httpSessionUtils = httpSessionUtils;
    }

    private static final Logger LOG= LoggerFactory.getLogger(CustomSessionListener.class);

    private final AtomicInteger counter = new AtomicInteger();

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        httpSessionUtils.put(se.getSession().getId(), se.getSession());
        LOG.info("New session is created.");
        counter.incrementAndGet();  //incrementing the counter
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        httpSessionUtils.remove(se.getSession().getId());
        LOG.info("Session destroyed.");
        counter.decrementAndGet();  //decrementing counter
    }


}