package com.lmx.springtimerevent.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author liumingxin
 * @create 2018 06 10:01
 * @desc
 **/
public class MyEvent extends ApplicationEvent {

    public MyEvent(Object source) {
        super(source);
    }
}
