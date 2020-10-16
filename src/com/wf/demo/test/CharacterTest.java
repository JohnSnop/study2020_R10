package com.wf.demo.test;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author wf
 * @create 2020-09-26 17:34
 * @desc
 **/
public class CharacterTest {
    @Test
    public void test1() throws UnsupportedEncodingException {
        String str = "�";
        System.out.println(new String(str.getBytes("UTF-8"), "GBK"));
    }

    /**
     * UTF-8 转 GBK
     * 乱码
     * @throws UnsupportedEncodingException
     */
    @Test
    public void test2() throws UnsupportedEncodingException {
        String str = "��";
        System.out.println(new String(str.getBytes("UTF-8"), "GBK"));
    }

    @Test
    public void test3() throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost.getHostAddress());
        System.out.println(localHost.getHostName());
    }

    @Test
    public void test4() {
        // String regex = "a+";// 至少一个
        // String regex = "a?";// 至多一个
        String regex = "a*";// 任意个
        System.out.println("".matches(regex));
        System.out.println("a".matches(regex));
        System.out.println("aaa".matches(regex));

    }

    @Test
    public void test5() {
        // unicode
        // utf-8
        System.out.println('\u2211');
    }
}
