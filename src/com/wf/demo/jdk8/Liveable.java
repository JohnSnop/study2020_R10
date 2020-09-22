package com.wf.demo.jdk8;

/**
 * @author wf
 * @create 2020-09-22 22:24
 * @desc
 **/
public interface Liveable {
    int NUM = 200;
    static void fly() {
        System.out.println("接口的静态方法");
    }

    default void run() {
        System.out.println("接口的默认实现");
    }
}
