package com.wf.demo.jdk8;

import org.junit.Test;

import java.io.File;
import java.util.LinkedList;

/**
 * @author wf
 * @create 2020-09-24 22:45
 * @desc
 **/
public class ListTest {
    @Test
    public void test1() {
        LinkedList<String> list = new LinkedList<>();
        list.addFirst("add1");
        list.addFirst("add2");
        list.addFirst("add3");
        list.addFirst("add4");
        System.out.println(list);

        System.out.println(list.getLast());

        System.out.println(list.removeFirst());

        while (!list.isEmpty()) {
            System.out.println(list.pop());
        }
        System.out.println(list);
    }

    @Test
    public void test2() {
        File file = new File("E:\\收藏的电影");
        // File file = new File("E:");

        getFiles(file);

    }

    private void getFiles(File file) {
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                for (File file1 : files) {
                    if (file1.isDirectory()) {
                        getFiles(file1);
                    } else {
                        System.out.println(file1);
                    }
                }
            } else {
                System.out.println(file);
            }
        } else {
            System.out.println("文件不存在");
            return;
        }

    }

    private void getFiles2(File file) {
        if (file != null) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File file1 : files) {
                    if (file1.isDirectory()) {
                        getFiles2(file1);
                    } else {
                        System.out.println(file);
                    }
                }
            }
        }
    }
}
