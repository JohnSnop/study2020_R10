package com.wf.demo.test;

/**
 * @author wf
 * @create 2020-10-16 16:11
 * @desc
 **/
public class InitOrderTest {

    private static int a = 0;
    static {
        a = 10;
        System.out.println("静态代码块在执行a=" + a);// Step 1
    }

    {
        a = 8;
        System.out.println("非静态代码块（构造代码块）在执行a=" + a);
    }

    public InitOrderTest() {
        this("调用带参构造方法1，a=" + a); // Step 2
        System.out.println("无参构造方法在执行a=" + a);// Step 7
    }

    public InitOrderTest(String n) {
        this(n, "调用带参构造方法2，a=" + a); // Step 3
        System.out.println("带参构造方法1在执行a=" + a); // Step 6
    }

    public InitOrderTest(String s1, String s2) {
        System.out.println(s1 + "；" + s2);// Step 5
    }

    public static void main(String[] args) {
        InitOrderTest t = null;// JVM加载Test类，静态代码块执行
        System.out.println("下面new一个Test实例：");
        t = new InitOrderTest();
        // t = new InitOrderTest("Hello");
    }

}
