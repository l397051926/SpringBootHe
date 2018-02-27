package com.lmx.demo.bean;

import lombok.Data;

/**
 * @author  liumingxin
 * @create   2018/2/26 10:29
 * @desc
 */
@Data
public class Person {

    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
