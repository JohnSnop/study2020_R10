package com.wf.demo.jdk8;

import org.junit.Test;

/**
 * @author wf
 * @create 2020-09-23 22:22
 * @desc
 **/
public class ExceptionTest {
    @Test
    public void test() {
        System.out.println(result());
    }
    int result() {
        int result;
        try {
            if (true) {
                throw new RuntimeException();
            }
            result = 5;
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            result = 6;
            return result;
        }
    }

    @Test
    public void test2() {
        String str = "\\d";
        String str2 = "\\.";
    }

    @Test
    public void test3() {
        String regex = ".*\\b[abc]\\b.*";
        String str = "abc a bbc";
        System.out.println(str.matches(regex));
    }
}
