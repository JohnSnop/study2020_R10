package com.wf.demo.test;

import org.junit.Test;

/**
 * @author wf
 * @create 2020-10-14 19:41
 * @desc
 **/
public class DebugTest {

    /**
     * 条件断点
     */
    @Test
    public void test1() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
    }

    /**
     * 回到"上一步"
     */
    @Test
    public void dropFrameDebug() {
        int i = 99;
        method1(i);
    }

    private void method1(int i) {
        System.out.println("method1:" + i);
        method2(i);
    }

    private void method2(int i) {
        i++;
        System.out.println("method2:" + i);
    }

    /**
     * 多线程调试
     */
    @Test
    public void multiThreadTest() {
        new Thread(() -> {
            System.out.println("STEP1");
        }, "T1").start();

        new Thread(() -> {
            System.out.println("STEP2");
        }, "T2").start();

        System.out.println("STEP3");
        System.out.println("STEP4");
    }
}
