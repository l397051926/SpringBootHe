package com.lmx.kafkademo.demo.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author liumingxin
 * @create 2018 24 17:17
 * @desc
 **/
@Component
@Slf4j
public class KafkaReceiver {

    @KafkaListener(topics = {"text1"})
    public void listen(ConsumerRecord<?,?> record){
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if(kafkaMessage.isPresent()){
            Object message = kafkaMessage.get();
            System.out.println("-----------------record ="+record);
            System.out.println("-----------------message ="+message);
        }
    }

}
