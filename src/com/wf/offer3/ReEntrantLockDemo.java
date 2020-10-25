package com.wf.offer3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wf
 * @create 2020-10-25 18:05
 * @desc
 * 可重入锁:可重复可递归调用的锁，在外层使用锁之后，在内层仍然可以使用，并且不发生死锁，这样的锁就叫做可重入锁。
 * 在一个synchronized修饰的方法或代码块的内部
 * 调用本类的其他synchronized修饰的方法或代码块时，是永远可以得到锁的
 **/
public class ReEntrantLockDemo {
    // 同一把锁
    static Object lock = new Object();

    private static Lock lockA = new ReentrantLock();

    private static void m2() {
        new Thread(() -> {
            lockA.lock();

            try {
                System.out.println("外层----");
                lockA.lock();
                try {
                    System.out.println("内层----");
                } catch (Exception e) {
                	e.printStackTrace();
                } finally {
                    lockA.unlock();
                }
            } catch (Exception e) {
            	e.printStackTrace();
            } finally {
                lockA.unlock();
            }
        }, "T1").start();
    }
    private static void m1() {
        new Thread(() -> {
            synchronized (lock) {
                System.out.println((Thread.currentThread().getName() + "\t" + "---外层调用"));
                synchronized (lock) {
                    System.out.println((Thread.currentThread().getName() + "\t" + "---中层调用"));
                    synchronized (lock) {
                        System.out.println((Thread.currentThread().getName() + "\t" + "---内层调用"));
                    }
                }
            }
        }, "T1").start();
    }
    public static void main(String[] args) {
        // m1();
        m2();
    }
}
