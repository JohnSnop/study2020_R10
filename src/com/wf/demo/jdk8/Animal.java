package com.wf.demo.jdk8;

import org.junit.Test;

/**
 * @author wf
 * @create 2020-09-22 22:26
 * @desc
 **/
public class Animal implements Liveable {
    @Override
    public void run() {
        System.out.println("Animal run");
    }

    @Test
    public void test() {
        Animal animal = new Animal();
        animal.run();
        // animal.fly(); 静态方法不能被实现

        Liveable.fly();
        System.out.println(Liveable.NUM);
    }
}
