package com.wf.demo.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.function.Supplier;

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

        list.add("CCC");
        list.add("AAA");
        list.add("DDD");
        list.add("BBB");
    }

    @Test
    public void test6() {

        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                System.out.println("Hello !");
            }, String.valueOf(i)).start();
        }
    }

    @Test
    public void test5() {
        Supplier<List<String>> sup = () -> new ArrayList<>();
        Supplier<List<String>> sup2 = ArrayList::new;

        Supplier<int[]> sup3 = () -> new int[10];
    }

    @Test
    public void test4() {
        /*Comparator<Integer> com = (a, b) -> {
            return Integer.compare(a, b);
        };*/
        // Comparator<Integer> com = (a, b) -> Integer.compare(a, b);
        Comparator<Integer> com = Integer::compare;
        Comparator<Integer> com2 = Integer::compareTo;
        System.out.println(com.compare(1, 2));
        System.out.println(com2.compare(1, 2));
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
