package com.wf.demo.test;

import org.junit.Test;
import sun.misc.Launcher;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wf
 * @create 2020-10-20 19:28
 * @desc
 **/
public class ClassLoaderTest {

    @Test
    public void test1() {
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        Arrays.stream(urLs).forEach(System.out::println);
    }

    @Test
    public void test2() {
        List list = new ArrayList();


    }
}
