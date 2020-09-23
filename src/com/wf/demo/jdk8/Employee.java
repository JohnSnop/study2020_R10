package com.wf.demo.jdk8;

/**
 * @author wf
 * @create 2020-09-23 21:29
 * @desc
 **/
public abstract class Employee {
    /**
     * 抽象类的抽象方法
     */
    public abstract void test();

    public void say() {
        System.out.println("非抽象方法");
    }
}
