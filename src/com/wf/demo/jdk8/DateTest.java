package com.wf.demo.jdk8;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.*;

/**
 * @author wf
 * @create 2020-10-23 11:49
 * @desc
 **/
public class DateTest {

    @Test
    public void test3() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        Callable<LocalDateTime> task = () -> LocalDateTime.parse("2020-10-23 10:00:00", formatter);
        ExecutorService service = Executors.newFixedThreadPool(10);

        ArrayList<Future<LocalDateTime>> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            futures.add(service.submit(task));
        }

        for (Future<LocalDateTime> future : futures) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        service.shutdown();
    }

    @Test
    public void test2() {

        Callable<Date> task = () -> DateFormatThreadLocal.convert("2020-10-23 10:00:00");

        ExecutorService service = Executors.newFixedThreadPool(10);

        ArrayList<Future<Date>> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            futures.add(service.submit(task));
        }

        for (Future<Date> future : futures) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        service.shutdown();
    }

    @Test
    public void test1() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Callable<Date> task = () -> sdf.parse("2020-10-23 10:00:00");

        ExecutorService service = Executors.newFixedThreadPool(10);

        ArrayList<Future<Date>> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            futures.add(service.submit(task));
        }
        /*try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        for (Future<Date> future : futures) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        service.shutdown();
    }
}
