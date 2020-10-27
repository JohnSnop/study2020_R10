package com.wf.offer3;

import org.junit.Test;

/**
 * @author wf
 * @create 2020-10-25 14:41
 * @desc
 **/
public class StringPoolDemo {

    @Test
    public void test1() {
        String str1 = new StringBuilder("58").append("tongcheng").toString();
        System.out.println(str1);
        System.out.println(str1.intern());
        System.out.println(str1 == str1.intern()); // true

        System.out.println("------------");

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2);
        System.out.println(str2.intern());
        System.out.println(str2 == str2.intern()); // false
    }

    @Test
    public void test2() {
        String str1 = "a";
        String str2 = "b";
        // final String str1 = "a";
        // final String str2 = "b";
        String str3 = "ab";
        String str4 = str1 + str2;
        System.out.println(str3 == str4);
    }

    @Test
    public void test3() {
        String str = "ab";
        String str2 = new String("a") + new String("b");
        String str3 = str2.intern();

        System.out.println(str == str3);// true
        System.out.println(str == str2);// false
    }
}
