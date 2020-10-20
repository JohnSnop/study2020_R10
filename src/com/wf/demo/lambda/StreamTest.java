package com.wf.demo.lambda;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.stream.LongStream;

/**
 * @author wf
 * @create 2020-10-19 19:18
 * @desc
 **/
public class StreamTest {

    @Test
    public void test5() {
        // 串行流(单线程)：切换为并行流 parallel()
        // 并行流：切换为串行流 sequential()
        Instant start = Instant.now();
        System.out.println(LongStream.rangeClosed(0, 100000000L)
            .parallel() // 底层：ForkJoin
            .reduce(0, Long::sum));
        Instant end = Instant.now();
        System.out.println("耗时：" + Duration.between(start, end).toMillis());
    }
    /**
     * 归约
     */
    @Test
    public void test4() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Integer integer = list.stream()
            .reduce(0, (x, y) -> x + y);
        System.out.println(integer);
    }

    @Test
    public void test3() {
        List<Integer> list = Arrays.asList(1, 3, 2, 6, 5);
        list.stream()
            .sorted()
            .forEach(System.out::println);

        // 流不改变原始的数据
        list.stream()
            .map(x -> x * x)
            .forEach(System.out::println);
    }
    @Test
    public void test2() {
        List<String> list = Arrays.asList("a", "b", "c");
        list.stream()
            .map(x -> x.toUpperCase())
            .forEach(System.out::println);

    }

    @Test
    public void test1() {
        String[] arr = new String[10];
        Arrays.stream(arr).iterator().forEachRemaining(t -> System.out.println(t));
    }
}
