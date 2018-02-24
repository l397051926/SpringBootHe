package com.lmx.kafkademo.demo.kafka.provider;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lmx.kafkademo.demo.kafka.beans.Message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

/**
 * @author liumingxin
 * @create 2018 24 17:17
 * @desc
 **/
@Component
@Slf4j
public class KafkaSender {
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;
    private Gson gson = new GsonBuilder().create();

    public void send(){
        Message message =new Message();
        message.setId(System.currentTimeMillis());
        message.setMsg(UUID.randomUUID().toString());
        message.setSendTime(new Date());

        System.out.println(gson.toJson(message));

        kafkaTemplate.send("text1",gson.toJson(message));

    }


}
