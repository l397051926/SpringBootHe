package com.lmx.kafkademo.demo.kafka.beans;

import java.util.Date;

/**
 * @author liumingxin
 * @create 2018 24 17:16
 * @desc
 **/
public class Message {
    private Long id;
    private String msg;
    private Date sendTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }
}
