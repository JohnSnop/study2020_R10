package com.wf.offer3;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wf
 * @create 2020-10-25 21:22
 * @desc
 **/
public class LockSupportDemo {
    static Object lock = new Object();
    private static Lock lockA = new ReentrantLock();
    private static Condition condition = lockA.newCondition();
    public static void main(String[] args) {
        demo5();
        // demo4();
        // demo3();
        // demo2();
        // demo1();
    }

    private static void demo5() {
        Thread a = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t" + "+++come in");
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + "\t" + "+++被唤醒");
        }, "T1");
        a.start();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            LockSupport.unpark(a);
            System.out.println(Thread.currentThread().getName() + "\t" + "+++通知");
        }, "T2").start();
    }

    private static void demo4() {
        new Thread(() -> {
            /*try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        	lockA.lock();
        	try {
        	    System.out.println(Thread.currentThread().getName() + "\t" + "+++come in");
                condition.await();
                System.out.println(Thread.currentThread().getName() + "\t" + "+++被唤醒");
        	} catch (Exception e) {
        		e.printStackTrace();
        	} finally {
        	    lockA.unlock();
        	}
        }, "T1").start();

        new Thread(() -> {
            lockA.lock();
            try {
                condition.signal();
                System.out.println(Thread.currentThread().getName() + "\t" + "+++通知");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lockA.unlock();
            }
        }, "T2").start();
    }

    private static void demo3() {
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + "\t" + "---come in");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "\t" + "===被唤醒");
            }
        }, "T1").start();

        new Thread(() -> {
            synchronized (lock) {
                lock.notify();
                System.out.println(Thread.currentThread().getName() + "\t" + "+++通知");
            }
        }, "T2").start();
    }
    private static void demo2() {
        new Thread(() -> {
            // synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + "\t" + "---come in");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "\t" + "===被唤醒");
            // }
        }, "T1").start();

        new Thread(() -> {
            // synchronized (lock) {
                lock.notify();
                System.out.println(Thread.currentThread().getName() + "\t" + "+++通知");
            // }
        }, "T2").start();
    }

    private static void demo1() {
        new Thread(() -> {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + "\t" + "---come in");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "\t" + "===被唤醒");
            }
        }, "T1").start();

        new Thread(() -> {
        	synchronized (lock) {
        	    lock.notify();
        	    System.out.println(Thread.currentThread().getName() + "\t" + "+++通知");
            }
        }, "T2").start();
    }
}
