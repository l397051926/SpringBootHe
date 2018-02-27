package com.lmx.springbatch3.demo;

import javax.swing.*;

/**
 * @author liumingxin
 * @create 2018 26 18:08
 * @desc
 **/
public class Demo1 {
    public static void main(String[] args) {
        System.out.println("java8 lamdba text");
        new Thread( () -> System.out.println("in java8 text!!")).start();

        JButton show =  new JButton("Show");

        show.addActionListener((e) ->{
            System.out.println("what is trouble is it?");
        });
    }

    public void text(String ...x){
    }


}
