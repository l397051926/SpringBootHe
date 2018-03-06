package com.lmx.springtimerevent.listener;

import com.lmx.springtimerevent.event.MyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author liumingxin
 * @create 2018 06 10:02
 * @desc
 **/
@Component
public class MyListener implements ApplicationListener<MyEvent> {

    //该注解 可以增加 事件各种发生情况  具体情况 还要查询
    //    @EventListener
    @Override
    public void onApplicationEvent(MyEvent myEvent) {

        System.out.println("接收事件： "+myEvent.getClass());
        System.out.println("处理事件。。。");
    }
}
