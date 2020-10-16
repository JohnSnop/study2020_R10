package com.wf.demo.jdk8;

import org.junit.Test;

/**
 * @author wf
 * @create 2020-09-22 22:46
 * @desc
 **/
public class Person {
    private boolean isLive = true;

    /**
     * 内部类
     */
    class Heart{
       public void jump() {
           if (isLive) {
               System.out.println("开心每一天");
           } else {
               System.out.println("生活的意义");
           }
       }
    }

    public void setLive(boolean isLive) {
        this.isLive = isLive;
    }

    @Test
    public void test() {
        Person person = new Person();
        /**
         * 创建方式
         */
        Heart heart = person.new Heart();

        heart.jump();
        person.setLive(false);
        heart.jump();
    }
}
