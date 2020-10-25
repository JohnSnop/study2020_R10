package com.wf.offer3;

/**
 * @author wf
 * @create 2020-10-25 14:41
 * @desc
 **/
public class StringPoolDemo {
    public static void main(String[] args) {
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

}
