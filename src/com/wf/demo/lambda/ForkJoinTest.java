package com.wf.demo.lambda;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.LongStream;

/**
 * @author wf
 * @create 2020-10-20 16:56
 * @desc
 **/
public class ForkJoinTest {

    @Test
    public void test1() {
        Instant start = Instant.now();
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinCalculate calculate = new ForkJoinCalculate(0, 100000000L);

        System.out.println(pool.invoke(calculate).longValue());
        Instant end = Instant.now();
        System.out.println("耗时：" + Duration.between(start, end).toMillis());
    }

    @Test
    public void test2() {
        Instant start = Instant.now();
        System.out.println(LongStream.rangeClosed(0, 100000000L)
            .parallel()
            .reduce(0, Long::sum));
        Instant end = Instant.now();
        System.out.println("耗时：" + Duration.between(start, end).toMillis());
    }
}
