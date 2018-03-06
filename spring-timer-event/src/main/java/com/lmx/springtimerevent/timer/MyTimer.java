package com.lmx.springtimerevent.timer;

import com.lmx.springtimerevent.event.MyEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author liumingxin
 * @create 2018 06 9:56
 * @desc
 **/
@Component
@EnableScheduling
public class MyTimer {

    @Autowired
    private ConfigurableApplicationContext context;

    @Scheduled(cron = "0/5 * * * * ?")
    public void  TimerTest(){
        System.out.println("每隔5秒 开启一个事件");
        context.publishEvent(new MyEvent(new Object()));
    }
}
