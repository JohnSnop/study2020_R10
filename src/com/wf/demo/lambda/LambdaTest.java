package com.wf.demo.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author wf
 * @create 2020-10-16 11:27
 * @desc
 **/
public class LambdaTest {

    private static HashMap<String, String> map = new HashMap<>();

    private static List<String> list = new ArrayList<>();

    static {
        map.put("111", "AAA");
        map.put("222", "BBB");
        map.put("333", "CCC");
        map.put("444", "DDD");
        map.put("555", "EEE");
        map.put("666", "FFF");
        map.put("777", "GGG");
        map.put("888", "HHH");

        list.add("AAA");
        list.add("CCC");
        list.add("DDD");
        list.add("BBB");
    }

    @Test
    public void test3() {
        list.sort((o1, o2) -> {
            return o1.compareTo(o2);
        });
        list.forEach(System.out::println);
    }

    @Test
    public void test2() {
        list.removeIf(ele -> ele.equals("BBB"));
        list.forEach(System.out::println);

        list.stream().iterator().forEachRemaining(System.out::println);
    }

    @Test
    public void test1() {

        /*map.keySet().forEach(t -> {
            System.out.println(t);
        });*/

        /*map.entrySet().forEach(t -> {
            System.out.println(t.getKey() + "==" + t.getValue());
        });*/

        list.forEach(System.out::println);
    }
}
